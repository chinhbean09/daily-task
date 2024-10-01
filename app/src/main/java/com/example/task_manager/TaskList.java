package com.example.task_manager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity implements SelectListener {
    private ArrayList<TaskModel> tasks = new ArrayList<>();
    TaskRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    MyDatabaseHelper myDB;
//    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_list);
        myDB = new MyDatabaseHelper(TaskList.this);
        setUpAppBar();
        setupTaskList();
        displayItems();
    }

    private void setUpAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void setupTaskList() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data. ", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                TaskModel task = new TaskModel(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                Log.d("MyApp", "setupTaskList: " + task.toString());
                tasks.add(task);
            }
        }
    }

    private void displayItems() {
        recyclerView = findViewById(R.id.mRecyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new TaskRecyclerViewAdapter(TaskList.this, this, tasks, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    @Override
    public void onItemClicked(TaskModel model) {
//        Toast.makeText(this, model.getName(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getApplicationContext(), TaskDetail.class);
//        intent.putExtra("task", model);
//        startActivity(intent);
//        activity.startActivityForResult(intent, 1);
    }
}