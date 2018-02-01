package com.example.elnapoli.petoperation.dataBase;

/**
 * Created by elnapoli on 31-01-18.
 */

public final class ConstantsDataBase {

    public static final String DATABASE_NAME = "Pets";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS         = "pets";
    public static final String TABLE_PETS_ID      = "id";
    public static final String TABLE_PETS_NAME    = "name";
    public static final String TABLE_PETS_PHOTO   = "photo";
    public static final String TABLE_PETS_RATING  = "rating";
    public static final String TABLE_PETS_IS_LIKE = "is_like";

    public static final String TABLE_PHOTO             = "photos";
    public static final String TABLE_PHOTO_ID          = "id";
    public static final String TABLE_PHOTO_RATING      = "rating";
    public static final String TABLE_PHOTO_SRC         = "src";
    public static final String TABLE_PHOTO_PET_ID      = "pet_id";

}
