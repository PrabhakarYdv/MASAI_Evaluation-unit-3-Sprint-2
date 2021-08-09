package com.prabhakar.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class ItemDetailsFragment extends Fragment {
    private TextView itemTitle, itemSubTitle;
    private ImageView itemImage;
    private String title, subTitle, image;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            image = getArguments().getString("img");
            subTitle = getArguments().getString("subtitle");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        itemImage = view.findViewById(R.id.item_img);
        itemTitle = view.findViewById(R.id.item_title);
        itemSubTitle = view.findViewById(R.id.item_subtitle);


        Glide.with(itemImage).load(image).into(itemImage);
        itemTitle.setText(title);
        itemSubTitle.setText(subTitle);
    }

}