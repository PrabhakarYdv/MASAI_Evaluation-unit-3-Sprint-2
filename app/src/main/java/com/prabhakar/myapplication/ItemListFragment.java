package com.prabhakar.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> item;
    private ItemAdapter itemAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        callAPI();
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }


    private void setAdapter() {
        itemAdapter = new ItemAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(itemAdapter);
    }

    private void callAPI() {
        APIService apiService = Network.getInstance().create(APIService.class);
        apiService.getItem().enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                if (response.body() != null) {
                    item = response.body();
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {

            }
        });

    }

}