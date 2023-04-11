package ru.packetSolution.hack.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.packetSolution.hack.adapters.RecyclerViewAdapter;
import ru.packetSolution.hack.databinding.FragmentHomeBinding;
import ru.packetSolution.hack.room.ItemEntity;

public class FragmentHome extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<ItemEntity> items;

    public FragmentHome(ArrayList<ItemEntity> items) {
        this.items = items;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(getContext()), container, false);
        initRecycler();
        return binding.getRoot();
    }
    private void initRecycler(){

        binding.recyclerView.setAdapter(new RecyclerViewAdapter(items));
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }
}
