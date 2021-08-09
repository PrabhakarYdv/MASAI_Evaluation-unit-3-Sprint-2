package com.prabhakar.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private ArrayList<ResponseModel> itemList;

    public ItemAdapter(ArrayList<ResponseModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ResponseModel model = itemList.get(position);
        holder.setItemData(model);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }
}
