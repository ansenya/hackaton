package ru.packetSolution.hack.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        return binding.getRoot();
    }
    private void initRecycler(){
        binding.recyclerView.setAdapter(new RecyclerViewAdapter(items));
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(getContext(), "not changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getContext(), "changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getContext(), "after changed", Toast.LENGTH_SHORT).show();
            }
        });
        getParentFragmentManager().beginTransaction().replace(binding.searchFragment.getId(), new FragmentSearch(items)).commit();
    }

    public void notifyAdapter(){
        binding.recyclerView.getAdapter().notifyDataSetChanged();
    }
}
