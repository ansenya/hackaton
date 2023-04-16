package ru.packetSolution.hack.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.databinding.EditUserActivityBinding;
import ru.packetSolution.hack.dialogs.DialogPasFragment;

public class EditUserActivity extends AppCompatActivity {

    private EditUserActivityBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = EditUserActivityBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_activity);



    }


    public void editPas(View view) {
        FragmentManager manager = getSupportFragmentManager();
        DialogPasFragment dialogPasFragment = new DialogPasFragment();
        dialogPasFragment.show(manager, "fragment_dialog_pas");
    }

    public void saveInfo(View view) {
        // TODO сохранение инфы в БД
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    public void editPhoto(View view) {
        // TODO изменение фото профиля
    }
}
