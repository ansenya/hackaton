package ru.packetSolution.hack.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import ru.packetSolution.hack.adapters.RecyclerViewAdapter;
import ru.packetSolution.hack.adapters.RecyclerViewAdapterForAdd;
import ru.packetSolution.hack.databinding.FragmentUserBinding;
import ru.packetSolution.hack.room.ItemEntity;


public class FragmentUser extends Fragment {

    FragmentUserBinding binding;
    private  ArrayList<ItemEntity> itemEntities;
    public FragmentUser(ArrayList<ItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(LayoutInflater.from(getContext()), container, false);
        initRecycler();
        return binding.getRoot();
    }

    private void initRecycler(){
        binding.recyclerView.setAdapter(new RecyclerViewAdapter(itemEntities, 3));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
