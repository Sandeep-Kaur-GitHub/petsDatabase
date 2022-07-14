package com.example.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PetDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "petInfo.db";

    public PetDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableCommand = "CREATE TABLE "+petContract.petEntry.TABLE_NAME+ "("
                +petContract.petEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + petContract.petEntry.COLUMN_PET_NAME +"TEXT NOT NULL,"
                + petContract.petEntry.COLUMN_PET_BREED+"TEXT,"
                + petContract.petEntry.COLUMN_PET_GENDER +"INTEGER NOT NULL,"
                + petContract.petEntry.COLUMN_PET_WEIGHT+"INTEGER NOT NULL DEFAULT 0);";

        sqLiteDatabase.execSQL(createTableCommand);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
