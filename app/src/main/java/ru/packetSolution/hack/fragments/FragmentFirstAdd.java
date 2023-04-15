package ru.packetSolution.hack.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.activities.MainActivity;
import ru.packetSolution.hack.adapters.RecyclerViewAdapter;
import ru.packetSolution.hack.adapters.RecyclerViewAdapterForAdd;
import ru.packetSolution.hack.databinding.FragmentFirstAddBinding;
import ru.packetSolution.hack.room.ItemEntity;

public class FragmentFirstAdd extends Fragment {
    FragmentFirstAddBinding binding;
    ArrayList<ItemEntity> items;
    public FragmentFirstAdd(ArrayList<ItemEntity> items) {
        this.items = items;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstAddBinding.inflate(LayoutInflater.from(getContext()), container, false);
        initRecycler();
        return binding.getRoot();
    }

    private void initRecycler(){
        binding.recyclerView.setAdapter(new RecyclerViewAdapterForAdd(items));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.ad.setOnClickListener(view -> {
            FragmentAdd nextFrag = new FragmentAdd(items);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
        });
    }

    public void notifyAdapter(){
        binding.recyclerView.getAdapter().notifyDataSetChanged();
    }

}