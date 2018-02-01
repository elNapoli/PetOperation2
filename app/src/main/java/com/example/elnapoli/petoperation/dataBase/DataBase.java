package com.example.elnapoli.petoperation.dataBase;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

/**
 * Created by elnapoli on 31-01-18.
 */

public class DataBase extends SQLiteOpenHelper {
    private Context context;
    private String name;

    public DataBase(Context context) {
        super(context, ConstantsDataBase.DATABASE_NAME, null, ConstantsDataBase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateTablePets = "CREATE TABLE " + ConstantsDataBase.TABLE_PETS +"("+
                ConstantsDataBase.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstantsDataBase.TABLE_PETS_NAME + " TEXT,"+
                ConstantsDataBase.TABLE_PETS_PHOTO + " INTEGER,"+
                ConstantsDataBase.TABLE_PETS_RATING + " INTEGER,"+
                ConstantsDataBase.TABLE_PETS_IS_LIKE + " INTEGER NOT NULL default 0"+
                ")";
        String queryCreateTablePhoto = "CREATE TABLE " + ConstantsDataBase.TABLE_PHOTO +"("+
                ConstantsDataBase.TABLE_PHOTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstantsDataBase.TABLE_PHOTO_RATING + " INTEGER,"+
                ConstantsDataBase.TABLE_PHOTO_SRC + " INTEGER,"+
                ConstantsDataBase.TABLE_PHOTO_PET_ID + " INTEGER,"+
                "FOREIGN KEY("+ ConstantsDataBase.TABLE_PHOTO_PET_ID+")"+
                "REFERENCES "+ ConstantsDataBase.TABLE_PETS+ "("+ ConstantsDataBase.TABLE_PETS_ID+")"+
                ")";
        sqLiteDatabase.execSQL(queryCreateTablePets);
        sqLiteDatabase.execSQL(queryCreateTablePhoto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantsDataBase.TABLE_PETS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantsDataBase.TABLE_PETS);
        onCreate(sqLiteDatabase);

    }

    public ArrayList<Pets> getPets(){
        ArrayList<Pets> pets = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantsDataBase.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Pets petActual = new Pets();
            petActual.setId(registros.getInt(0));
            petActual.setName(registros.getString(1));
            petActual.setPhoto(registros.getInt(2));
            petActual.setRating(registros.getInt(3));
            petActual.setIsLike(registros.getInt(4)>0);

            pets.add(petActual);
        }
        db.close();
        return pets;
    }

    public void insertPet(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDataBase.TABLE_PETS,null,contentValues);
        db.close();
    }
}
