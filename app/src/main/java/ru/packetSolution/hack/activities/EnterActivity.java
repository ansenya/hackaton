package ru.packetSolution.hack.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.packetSolution.hack.databinding.ActivityEnterBinding;


public class EnterActivity extends AppCompatActivity {

    ActivityEnterBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private final String authorized = "Authorized";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityEnterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        binding.wrong.setVisibility(View.GONE);
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        init();

        mAuth = FirebaseAuth.getInstance();
    }

    void init() {
        binding.signIn.setOnClickListener(view -> {
            try {
                signIn(binding.inputEmail.getInputText(), binding.inputPassword.getInputText());
            } catch (NullPointerException | NumberFormatException e) {
                Toast.makeText(this, "Заполните данные!", Toast.LENGTH_SHORT).show();
                return; // Добавляем return, чтобы при ошибке не продолжать выполнение кода
            }
            finally {
                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
            }

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        binding.registration.setOnClickListener(view -> {
            startActivity(new Intent(this, RegistrationActivity.class));
        });
    }

    public void signIn(String email, String password) throws NullPointerException{
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
                            Toast.makeText(EnterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    private void updateUI(FirebaseUser user) {

    }


}
