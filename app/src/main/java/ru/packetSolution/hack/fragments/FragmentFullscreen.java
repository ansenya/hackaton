package ru.packetSolution.hack.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.packetSolution.hack.databinding.FragmentFullscreenBinding;

public class FragmentFullscreen extends Fragment {

    FragmentFullscreenBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFullscreenBinding.inflate(LayoutInflater.from(getContext()), container, false);
        return binding.getRoot();
    }

    public void setImage(){

    }


}
