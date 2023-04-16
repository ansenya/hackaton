package ru.packetSolution.hack.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.drawable.BitmapDrawable;

import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.GregorianCalendar;
import java.util.List;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.databinding.ActivityPhotoViewerBinding;

public class PhotoViewerActivity extends AppCompatActivity {

    // for check
    private static final int NORM = 1;
    private static final int REQUEST_TAKE_PHOTO = 1;

    // image
    ActivityPhotoViewerBinding binding;

    private Bitmap bitmap;
    private List<String> labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);
        binding = ActivityPhotoViewerBinding.inflate(getLayoutInflater());
        setPhoto();

        binding.cancel.setOnClickListener(v -> {
            cancelPhoto();
        });
        binding.save.setOnClickListener(view -> {
            savePhoto();
        });
    }
    public void setPhoto() {
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        binding.preview.setImageBitmap(bmp);
        bitmap = bmp;
    }

    public Bitmap getPhoto() {
        binding.preview.buildDrawingCache();
        BitmapDrawable drawable = (BitmapDrawable) binding.preview.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Bitmap bt = Bitmap.createBitmap(bitmap, 0, (int) (bitmap.getHeight() * 0.35), (int) (bitmap.getWidth() * 0.926), (int) (bitmap.getHeight() * 0.156));
        return bt;
    }

    public void cancelPhoto() {
        binding.preview.setImageDrawable(null);
        Intent intent = new Intent(PhotoViewerActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void savePhoto() {
        bitmap = getPhoto();
        Intent intent = new Intent(PhotoViewerActivity.this, MainActivity.class);
        startActivity(intent);
    }
}