package com.prabhakar.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ItemListActivity extends AppCompatActivity implements CommunicationListener{

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ItemListFragment itemListFragment = new ItemListFragment();
        fragmentTransaction.add(R.id.fragment, itemListFragment, "ItemFragment").commit();
    }


    @Override
    public void launchItemDetailsFragment(int position) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ItemDetailsFragment itemDetailsFragment = new ItemDetailsFragment();
        fragmentTransaction.replace(R.id.fragment, itemDetailsFragment, "ItemDetailsFragment").addToBackStack("").commit();
    }
}