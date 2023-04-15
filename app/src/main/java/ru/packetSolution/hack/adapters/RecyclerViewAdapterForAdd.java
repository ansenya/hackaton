package ru.packetSolution.hack.adapters;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.room.ItemEntity;

public class RecyclerViewAdapterForAdd extends RecyclerView.Adapter<RecyclerViewAdapterForAdd.ViewHolder> {

    List<ItemEntity> items;

    public RecyclerViewAdapterForAdd(List<ItemEntity> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterForAdd.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_add, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterForAdd.ViewHolder holder, int position) {
        holder.setContainer(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView roundedImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView = itemView.findViewById(R.id.pic);
        }

        void setContainer(ItemEntity item){
            if (BitmapFactory.decodeFile(item.getPath())==null){
                roundedImageView.setImageResource(R.drawable.img);
            } else {
                roundedImageView.setImageBitmap(BitmapFactory.decodeFile(item.getPath()));
            }
        }
    }
}
