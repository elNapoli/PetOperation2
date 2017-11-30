package com.example.elnapoli.petoperation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.elnapoli.petoperation.adapters.PetAdapter;
import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

public class FavouritePet extends AppCompatActivity {
    ArrayList<Pets> requestPet,tempPet;
    private RecyclerView rvFavouritePet;
    PetAdapter miAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_pet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundleObject = getIntent().getExtras();
        requestPet =  (ArrayList<Pets>) bundleObject.getSerializable("myPets");

        rvFavouritePet = (RecyclerView) findViewById(R.id.rvFavouritePet);
        miAdapter = new PetAdapter(this,requestPet);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavouritePet.setLayoutManager(llm);
        rvFavouritePet.setAdapter(miAdapter);

    }

}
