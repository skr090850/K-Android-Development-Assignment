package com.example.founderdetailsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Item> itemList;

    public MyAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item currentItem = itemList.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.titleView.setText(currentItem.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Founder.class);
                intent.putExtra("IMAGE_KEY",currentItem.getImage());
                intent.putExtra("TITLE_KEY",currentItem.getTitle());
                intent.putExtra("DECS_KEY",currentItem.getDecs());
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return itemList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleView;
        public MyViewHolder(View itemView){
            super(itemView);
            imageView= itemView.findViewById(R.id.card_image);
            titleView = itemView.findViewById(R.id.card_title);
        }
    }
}
