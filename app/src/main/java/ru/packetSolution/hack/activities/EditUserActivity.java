package ru.packetSolution.hack.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.packetSolution.hack.R;
import ru.packetSolution.hack.data.api.users.UsersApiService;
import ru.packetSolution.hack.databinding.EditUserActivityBinding;
import ru.packetSolution.hack.dialogs.DialogPasFragment;

public class EditUserActivity extends AppCompatActivity {

    private EditUserActivityBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = EditUserActivityBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_activity);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();


    }


    public void editPas(View view) {
        FragmentManager manager = getSupportFragmentManager();
        DialogPasFragment dialogPasFragment = new DialogPasFragment();
        dialogPasFragment.show(manager, "fragment_dialog_pas");
    }

    public void saveInfo(View view) {
        // TODO сохранение инфы в БД
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        UsersApiService.getInstance().updateUser(user.getIdToken(false)).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    public void editPhoto(View view) {
        // TODO изменение фото профиля
    }
}
