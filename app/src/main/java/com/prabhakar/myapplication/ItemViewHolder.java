package com.prabhakar.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private ImageView image;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        title = itemView.findViewById(R.id.item_title);
        image = itemView.findViewById(R.id.item_img);
    }

    public void setItemData(ResponseModel responseModel) {
        title.setText(responseModel.getTitle());
        Glide.with(image).load(responseModel.getImage()).into(image);
    }
}
