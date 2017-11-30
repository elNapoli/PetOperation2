package com.example.elnapoli.petoperation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

public class FavouritePet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_pet);

        Bundle bundleObject = getIntent().getExtras();
        ArrayList<Pets> misMascotas =  (ArrayList<Pets>) bundleObject.getSerializable("misMascotas");
        Log.d("asdf",misMascotas.get(0).getName());

    }
}
