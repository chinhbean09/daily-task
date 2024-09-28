package com.example.task_manager;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_list);
        displayItems();
    }

    private void setupTaskList() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
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