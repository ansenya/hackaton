package ru.packetSolution.hack.adapters;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.filter.ItemFilter;
import ru.packetSolution.hack.room.ItemEntity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<ItemEntity> items;
    private int idView;
    private int layoutId;
    private static final String TAG = "EmailPassword";

    public RecyclerViewAdapter() {
        this.items = items;
        if(idView == 1) this.layoutId = R.layout.view_item;
        if(idView == 2) this.layoutId = R.layout.view_item_add;
        if(idView == 3) this.layoutId = R.layout.view_item_favourite;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
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
        TextView name;
        TextView price;
        TextView geo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView = itemView.findViewById(R.id.pic);
            name = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.price);
        }

        public void setContainer(ItemEntity item) {
            if (item.getDrawablePic() == 0){
                if (BitmapFactory.decodeFile(item.getPath())==null){
                    roundedImageView.setImageResource(R.drawable.img);
                } else {
                    roundedImageView.setImageBitmap(BitmapFactory.decodeFile(item.getPath()));
                }
            } else {
                roundedImageView.setImageResource(item.getDrawablePic());
            }
            name.setText(item.getText());
            try{
                price.setText(item.getPrice() + "");

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    private ItemFilter filter = new ItemFilter();

    public Filter getFilter() {
        return new ItemFilter();
    }

}
