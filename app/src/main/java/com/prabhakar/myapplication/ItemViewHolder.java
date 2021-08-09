package com.prabhakar.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private ImageView image;
    private LinearLayout linearLayout;
    private ItemClickListener itemClickListener;

    public ItemViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        title = itemView.findViewById(R.id.item_title);
        image = itemView.findViewById(R.id.item_img);
        linearLayout = itemView.findViewById(R.id.item_card);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(getAdapterPosition());
            }
        });
    }

    public void setItemData(ResponseModel responseModel) {
        title.setText(responseModel.getTitle());
        Glide.with(image).load(responseModel.getImage()).into(image);
    }
}
