package com.example.elnapoli.petoperation.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.util.Base64DataException;

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
      /*  ArrayList<Pets>  myPets = new ArrayList<>();
        myPets.add(new Pets("Burbuja", R.drawable.elefante));
        myPets.add(new Pets("Perry", R.drawable.jirafa));
        myPets.add(new Pets("Osoman",R.drawable.leon));
        myPets.add(new Pets("Mano Larga",R.drawable.mono));
        myPets.add(new Pets("Diego",R.drawable.tigre));
        myPets.add(new Pets("Lobo",R.drawable.dray3115_edit_3_200x200));*/
        DataBase db = new DataBase(context);
        initPets(db);
        return db.getPets();
    }
    public void initPets(DataBase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME,"Burbuja");
        contentValues.put(ConstantsDataBase.TABLE_PETS_PHOTO,R.drawable.elefante);
        contentValues.put(ConstantsDataBase.TABLE_PETS_RATING,50);
        contentValues.put(ConstantsDataBase.TABLE_PETS_IS_LIKE,0);
        db.insertPet(contentValues);


        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME,"Perry");
        contentValues.put(ConstantsDataBase.TABLE_PETS_PHOTO,R.drawable.jirafa);
        contentValues.put(ConstantsDataBase.TABLE_PETS_RATING,4);
        contentValues.put(ConstantsDataBase.TABLE_PETS_IS_LIKE,0);

        db.insertPet(contentValues);

        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME,"Osoman");
        contentValues.put(ConstantsDataBase.TABLE_PETS_PHOTO,R.drawable.leon);
        contentValues.put(ConstantsDataBase.TABLE_PETS_RATING,4);
        contentValues.put(ConstantsDataBase.TABLE_PETS_IS_LIKE,0);

        db.insertPet(contentValues);

        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME,"Mano Larga");
        contentValues.put(ConstantsDataBase.TABLE_PETS_PHOTO,R.drawable.mono);
        contentValues.put(ConstantsDataBase.TABLE_PETS_RATING,100);
        contentValues.put(ConstantsDataBase.TABLE_PETS_IS_LIKE,0);
        db.insertPet(contentValues);


        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME,"Diego");
        contentValues.put(ConstantsDataBase.TABLE_PETS_PHOTO,R.drawable.tigre);
        contentValues.put(ConstantsDataBase.TABLE_PETS_RATING,34);
        contentValues.put(ConstantsDataBase.TABLE_PETS_IS_LIKE,0);
        db.insertPet(contentValues);

        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME,"Lobo");
        contentValues.put(ConstantsDataBase.TABLE_PETS_PHOTO,R.drawable.dray3115_edit_3_200x200);
        contentValues.put(ConstantsDataBase.TABLE_PETS_RATING,3);
        contentValues.put(ConstantsDataBase.TABLE_PETS_IS_LIKE,0);

        db.insertPet(contentValues);

    }

    public void setLikePet(Pets pet){
        DataBase db = new DataBase(context);
        db.updateLikePet(pet);
    }

    public int getLikePet(Pets pet){
        DataBase db = new DataBase(context);
        return  db.getLikePet(pet);

    }
}
