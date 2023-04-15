package ru.packetSolution.hack.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import ru.packetSolution.hack.adapters.RecyclerViewAdapter;
import ru.packetSolution.hack.databinding.FragmentSearchBinding;
import ru.packetSolution.hack.room.ItemEntity;

public class FragmentSearch extends Fragment {
    FragmentSearchBinding binding;
    ArrayList<ItemEntity> items;
    ArrayList<ItemEntity> itemsSearch = new ArrayList<>();

    public FragmentSearch(ArrayList<ItemEntity> items) {
        this.items = items;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(LayoutInflater.from(getContext()), container, false);
        initRecycler();
        return binding.getRoot();
    }

    private void initRecycler(){
        binding.searchList.setAdapter(new RecyclerViewAdapter(itemsSearch));
        binding.searchList.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}
