package com.example.task_manager;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity implements SelectListener {
    private ArrayList<TaskModel> tasks = new ArrayList<>();
    TaskRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    MyDatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_list);
        myDB = new MyDatabaseHelper(TaskList.this);
        setupTaskList();
        displayItems();
    }

    private void setupTaskList() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data. ", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                TaskModel task = new TaskModel(cursor.getString(1), cursor.getString(2));
                tasks.add(task);
            }
        }
    }

    private void displayItems() {
        recyclerView = findViewById(R.id.mRecyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new TaskRecyclerViewAdapter(this, tasks, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClicked(TaskModel model) {
        Toast.makeText(this, model.getName(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getApplicationContext(), FruitDetailActivity.class);
//        intent.putExtra("fruit", model);
//        startActivity(intent);
    }
}