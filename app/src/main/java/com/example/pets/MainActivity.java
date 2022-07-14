package com.example.pets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.pets.data.PetDbHelper;
import com.example.pets.data.petContract;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
   private PetDbHelper petdbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton FAB = findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EditActivity.class);
                startActivity(i);

            }
        });
         petdbhelper = new PetDbHelper(this);
    }

    public void displayDatabaseInfo() {

        SQLiteDatabase db = petdbhelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + petContract.petEntry.TABLE_NAME, null);
        Log.i("hbhf", "e" + cursor.getCount());
    }
    public void insertInfo()
    {
        SQLiteDatabase db=petdbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(petContract.petEntry.COLUMN_PET_NAME, "Toto");
        values.put(petContract.petEntry.COLUMN_PET_BREED, "Terrier");
        values.put(petContract.petEntry.COLUMN_PET_GENDER, petContract.petEntry.GENDER_MALE);
        values.put(petContract.petEntry.COLUMN_PET_WEIGHT, 7);
        long newRowId = db.insert(petContract.petEntry.TABLE_NAME, null, values);
        Log.i("hvg","vg"+newRowId);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_addition:
                insertInfo();
                displayDatabaseInfo();
            case R.id.action_deletion:

        }

        return super.onOptionsItemSelected(item);
    }
}