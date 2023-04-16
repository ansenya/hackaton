package ru.packetSolution.hack.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.packetSolution.hack.data.api.users.UsersApiService;
import ru.packetSolution.hack.databinding.ActivityRegistartionBinding;

public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private static final String TAG = "EmailPassword";

    ActivityRegistartionBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final String authorized = "Authorized";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegistartionBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        init();

        binding.button.setOnClickListener(view ->{
            createAccount(binding.inputEmail.getInputText(), binding.inputPassword.getInputText());
            //Intent intent = new Intent(RegistrationActivity.this,EnterActivity.class);
            //startActivity(intent);
            //onBackPressed();
            //signIn(binding.inputEmail.getInputText(), binding.inputPassword.getInputText());
        });

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }


    private void init() {
        binding.button.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        binding.switcher.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            UsersApiService.getInstance().insertUser(email,password).enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {

                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {

                                }
                            });
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(RegistrationActivity.this, "Успешная регистрация",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    private void sendEmailVerification() {
        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Email sent
                    }
                });
        // [END send_email_verification]
    }

    private void reload() { }

    private void updateUI(FirebaseUser user) {

    }

}
