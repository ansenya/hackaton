package ru.packetSolution.hack.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.adapters.RecyclerViewAdapter;
import ru.packetSolution.hack.databinding.FragmentSearchBinding;

//TODO:в фигме нет фрагмента с поиском, так что нужно поиск сделать в home

public class FragmentSearch extends Fragment {

    FragmentSearchBinding binding;
    //ArrayList<Animals> searchList;

    public FragmentSearch() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(LayoutInflater.from(getContext()), container, false);
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
        return binding.getRoot();
    }
}
