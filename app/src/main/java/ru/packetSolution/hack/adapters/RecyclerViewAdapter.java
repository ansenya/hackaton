package ru.packetSolution.hack.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.room.ItemEntity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<ItemEntity> items;

    public RecyclerViewAdapter(ArrayList<ItemEntity> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setContainer(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView roundedImageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView = itemView.findViewById(R.id.pic);
            textView = itemView.findViewById(R.id.text);
        }

        public void setContainer(ItemEntity item){
            roundedImageView.setImageResource(item.getDrawablePic());
            textView.setText(item.getText());
        }
    }
}
