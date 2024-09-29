package com.example.task_manager;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Task.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABBLE_NAME = "my_task";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "task_name";
    private static final String COLUMN_TIME = "task_time";
    private static final String COLUMN_LOCATION = "task_location";
    private static final String COLUMN_DESCRIPTION = "task_description";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABBLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_TIME + " TEXT, "
                + COLUMN_LOCATION + " TEXT, "
                + COLUMN_DESCRIPTION + " TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABBLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
