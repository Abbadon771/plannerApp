package com.example.abbadon.moblieappsfinal2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.example.abbadon.moblieappsfinal2.SQLDatabases.MedicalDbSchema;
import com.example.abbadon.moblieappsfinal2.SQLDatabases.MedicalHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button med;
    Button MedicalList;
    MedicalHelper mDb;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        med = (Button) findViewById(R.id.medicalBut);
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mView) {
                Intent mIntent = new Intent(getApplicationContext(), InputMedical.class);
                startActivityForResult(mIntent, 0);
            }
        });

        MedicalList =(Button) findViewById(R.id.medListBut);
        MedicalList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View oView) {
                startActivity(new Intent(MainActivity.this,MedicalList.class));
            }
        }
        );

    }

    @Override
    public void onActivityResult(int rCode, int nCode, Intent data) {
        if (rCode == 0) {
            if (nCode == RESULT_OK) {

                String MTitle = data.getStringExtra("Mtitle");
                String MDay = data.getStringExtra("Mday");
                String MMonth = data.getStringExtra("Mmonth");
                String MTime = data.getStringExtra("Mtime");
                String MProfession = data.getStringExtra("Mprofession");
                String MReason = data.getStringExtra("Mreason");
                mDb = new MedicalHelper(getApplicationContext());
                db = mDb.getWritableDatabase();
                mDb.addMedData(MTitle, MDay, MMonth, MTime, MReason, MProfession, db);
                mDb.close();
            }
        }
    }

}
