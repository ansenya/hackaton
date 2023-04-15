package ru.packetSolution.hack.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.adapters.RecyclerTouchListener;
import ru.packetSolution.hack.adapters.RecyclerViewAdapter;
import ru.packetSolution.hack.databinding.FragmentHomeBinding;
import ru.packetSolution.hack.interfaces.myInterface;
import ru.packetSolution.hack.room.ItemEntity;

public class FragmentHome extends Fragment implements myInterface {


    FragmentHomeBinding binding;
    ArrayList<ItemEntity> items;
    ArrayList<ItemEntity> itemsSearch = new ArrayList<>();
    FragmentFullscreen fragmentFullscreen = new FragmentFullscreen();

    public FragmentHome(ArrayList<ItemEntity> items) {
        this.items = items;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(getContext()), container, false);
        binding.input.clearFocus();
        /*View v = inflater.inflate(R.layout.fragment_search,container,false);
        SearchView sv = (SearchView) v.findViewById(R.id.search);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Animals> animalsList = (ArrayList<Animals>) bd.getAllAnimals();
                searchList = new ArrayList<>();
                for (Animals animal : animalsList) {
                    if (animal.getName().toLowerCase().contains(newText.toLowerCase())) {
                        searchList.add(animal);
                    }
                }
                RecyclerView rv = (RecyclerView) v.findViewById(R.id.recycler_view1);
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(FragmentSearch.this, searchList); //?
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(FragmentSearch.this)); //?
                adapter.notifyDataSetChanged();
                return false;
            }
        }); */
        initRecycler();
        initListeners();
        return binding.getRoot();
    }

    private void initRecycler() {
        binding.recyclerView.setAdapter(new RecyclerViewAdapter(items, 1));
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        binding.recyclerViewSearch.setAdapter(new RecyclerViewAdapter(items, 1));
        binding.recyclerViewSearch.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        getParentFragmentManager().beginTransaction().replace(binding.searchFragment.getId(), new FragmentSearch(items)).replace(binding.fullscreen.getId(), fragmentFullscreen).commit();
    }

    private void initListeners() {
        binding.recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), binding.recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                binding.fullscreen.setVisibility(View.VISIBLE);
                fragmentFullscreen.setImage(items.get(position));
                binding.others.setVisibility(View.GONE);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        binding.input.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                for (ItemEntity item:items){
                    if (item.getText().toLowerCase().contains(newText.toLowerCase())) {
                        itemsSearch.add(item);
                    }
                }
                binding.recyclerViewSearch.setVisibility(View.VISIBLE);
                binding.recyclerView.setVisibility(View.GONE);
                return false;
            }
        });
    }

    public void notifyAdapter() {
        binding.recyclerView.getAdapter().notifyDataSetChanged();
    }

    public boolean fullscreen() {
        return binding.fullscreen.getVisibility() == View.VISIBLE;
    }

    public void back() {
        binding.fullscreen.setVisibility(View.GONE);
        binding.others.setVisibility(View.VISIBLE);
    }

    @Override
    public void clicked() {

    }

    @Override
    public void onStart() {
        fragmentFullscreen.binding.back.setOnClickListener(view -> {
            binding.fullscreen.setVisibility(View.GONE);
        });
        super.onStart();
    }
}
