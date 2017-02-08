package com.example.abbadon.moblieappsfinal2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.example.abbadon.moblieappsfinal2.SQLDatabases.MedicalHelper;


public class MedicalList extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    MedicalHelper medicalHelper;
    Cursor medCursor;
    ListView MedicList;
    ListMedAdapter listMedAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_list);
        MedicList = (ListView)findViewById(R.id.med_list);
        listMedAdapter = new ListMedAdapter(getApplicationContext(), R.layout.medical_layout);
        MedicList.setAdapter(listMedAdapter);
        medicalHelper = new MedicalHelper(getApplicationContext());
        sqLiteDatabase = medicalHelper.getReadableDatabase();
        medCursor = medicalHelper.getData(sqLiteDatabase);
        if(medCursor.moveToFirst())
        {
            do{
                String mtitle, mday, mmonth, mtime, mprofession, mreason;
                mtitle = medCursor.getString(0);
                mday = medCursor.getString(1);
                mmonth = medCursor.getString(2);
                mtime = medCursor.getString(3);
                mprofession = medCursor.getString(4);
                mreason = medCursor.getString(5);
                MedicalSorter medicalSorter = new MedicalSorter(mtitle,mday,mmonth,mtime,mprofession,mreason);
                listMedAdapter.add(medicalSorter);
            }while(medCursor.moveToNext());
        }
    }

}
