package com.example.elnapoli.petoperation.dataBase;

import android.content.Context;

import com.example.elnapoli.petoperation.R;
import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

/**
 * Created by elnapoli on 29-01-18.
 */

public class BuilderPets {
    private Context context;
    public BuilderPets(Context context){
        this.context = context;

    }
    public ArrayList<Pets> getPets(){
        ArrayList<Pets>  myPets = new ArrayList<>();
        myPets.add(new Pets("Burbuja", R.drawable.elefante));
        myPets.add(new Pets("Perry", R.drawable.jirafa));
        myPets.add(new Pets("Osoman",R.drawable.leon));
        myPets.add(new Pets("Mano Larga",R.drawable.mono));
        myPets.add(new Pets("Diego",R.drawable.tigre));
        myPets.add(new Pets("Lobo",R.drawable.dray3115_edit_3_200x200));
        return myPets;
    }
}
