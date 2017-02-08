package com.example.abbadon.moblieappsfinal2.SQLDatabases;

/**
 * Created by Abbadon on 12/12/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Abbadon on 12/9/2016.
 */

public class MedicalHelper extends SQLiteOpenHelper {
    private static final int VERSION = 3;
    private static final String DATABASE_NAME = "medicalTable.db";
    private static final String CREATE_QUERY = "CREATE TABLE " + MedicalDbSchema.MedicalTable.NAME + " (" +
            MedicalDbSchema.MedicalTable.Cols.TITLE + " TEXT," +
            MedicalDbSchema.MedicalTable.Cols.DAY + " TEXT," +
            MedicalDbSchema.MedicalTable.Cols.MONTH + " TEXT,"
            + MedicalDbSchema.MedicalTable.Cols.TIME + " TEXT," + MedicalDbSchema.MedicalTable.Cols.PROFESSION + " TEXT,"
            + MedicalDbSchema.MedicalTable.Cols.DESCRIPTION +
            " TEXT);";


    public MedicalHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);

    }

    public void addMedData(String title, String day, String month, String time, String description,
                           String profession, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MedicalDbSchema.MedicalTable.Cols.TITLE, title);
        contentValues.put(MedicalDbSchema.MedicalTable.Cols.DAY, day);
        contentValues.put(MedicalDbSchema.MedicalTable.Cols.MONTH, month);
        contentValues.put(MedicalDbSchema.MedicalTable.Cols.TIME, time);
        contentValues.put(MedicalDbSchema.MedicalTable.Cols.PROFESSION, profession);
        contentValues.put(MedicalDbSchema.MedicalTable.Cols.DESCRIPTION, description);
        db.insert(MedicalDbSchema.MedicalTable.NAME,null,contentValues);
    }
    public Cursor getData(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projection = {MedicalDbSchema.MedicalTable.Cols.TITLE, MedicalDbSchema.MedicalTable.Cols.DAY,
                MedicalDbSchema.MedicalTable.Cols.MONTH, MedicalDbSchema.MedicalTable.Cols.TIME
                , MedicalDbSchema.MedicalTable.Cols.PROFESSION, MedicalDbSchema.MedicalTable.Cols.DESCRIPTION};
        cursor = db.query(MedicalDbSchema.MedicalTable.NAME,projection,null,null,null,null,null);
        return cursor;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }



}