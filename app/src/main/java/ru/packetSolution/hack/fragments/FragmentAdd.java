package ru.packetSolution.hack.fragments;

import static android.app.Activity.RESULT_OK;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.activities.MainActivity;
import ru.packetSolution.hack.databinding.ActivityMainBinding;
import ru.packetSolution.hack.databinding.FragmentAddBinding;
import ru.packetSolution.hack.databinding.FragmentHomeBinding;
import ru.packetSolution.hack.room.App;
import ru.packetSolution.hack.room.ItemEntity;
import ru.packetSolution.hack.views.InputField;


public class FragmentAdd extends Fragment {

    FragmentAddBinding binding;
    String path;


    FragmentHome fragmentHome = new FragmentHome(null);
    ArrayList<ItemEntity> items;

    public FragmentAdd(ArrayList<ItemEntity> items){
        this.items = items;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(LayoutInflater.from(getContext()), container, false);
        init();
        return binding.getRoot();
    }

    void init(){
        binding.pic.setOnClickListener(view ->{
            startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).addFlags(FLAG_GRANT_READ_URI_PERMISSION), 3);
        });
        InputField name = binding.name;
        InputField description = binding.description;
        InputField price = binding.price;
        Button btn = binding.button;
        ImageView pic = binding.pic;
        btn.setOnClickListener(view -> {
            try {
                int priceValue = Integer.parseInt(price.getInputText());
                ItemEntity itemEntity = new ItemEntity(path, name.getInputText(), description.getInputText(), priceValue);
                items.add(itemEntity);
                new Thread(() -> App.getDatabase().itemDao().save(itemEntity)).start();
                Toast.makeText(getActivity(), "Добавлено!", Toast.LENGTH_LONG).show();
            } catch (NullPointerException e) {
                Toast.makeText(getContext(), "Заполните данные", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Заполните данные", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            path = getRealPath(getContext(), data.getData());
            Log.e("MyTag", path);
            binding.pic.setImageBitmap(BitmapFactory.decodeFile(path));
        }
    }

    private static String getRealPath(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        String result = null;
        CursorLoader cursorLoader = new CursorLoader(
                context,
                contentUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();

        if (cursor != null) {
            int column_index =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            result = cursor.getString(column_index);
        }
        return result;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}