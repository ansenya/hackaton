package ru.packetSolution.hack.filter;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import ru.packetSolution.hack.activities.MainActivity;
import ru.packetSolution.hack.adapters.RecyclerViewAdapter;
import ru.packetSolution.hack.room.ItemEntity;

public class ItemFilter extends Filter {

    private  List<ItemEntity> filteredList = new ArrayList<>();
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();
        String query = constraint.toString().toLowerCase();

        ArrayList<ItemEntity> fullList = new ArrayList<>();
        fullList.addAll(recyclerViewAdapter.getItems());

        if (query.isEmpty()) {
            filteredList.addAll(fullList); // если запрос пустой, возвращаем весь список
        } else {
            for (ItemEntity item : fullList) {
                if (item.getText().toLowerCase().contains(query)) { // проверяем, содержит ли элемент искомый текст
                    filteredList.add(item);
                }
            }
        }

        FilterResults results = new FilterResults();
        results.count = filteredList.size();
        results.values = filteredList;
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        filteredList.clear();
        filteredList.addAll((List<ItemEntity>) results.values);
    }
}

