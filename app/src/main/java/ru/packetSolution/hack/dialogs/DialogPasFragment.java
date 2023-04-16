package ru.packetSolution.hack.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import ru.packetSolution.hack.R;

public class DialogPasFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(inflater.inflate(R.layout.fragment_dialog_pas, null))
                .setTitle("Изменение пароля")
                // Add action buttons
                .setPositiveButton("Изменить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
/*
                        TODO изменение пароля + проверка
*/
                        Toast.makeText(getContext(), "Пароль был успешно изменен", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Позже", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogPasFragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }
}
