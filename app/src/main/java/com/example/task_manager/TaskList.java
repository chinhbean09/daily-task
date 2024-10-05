package com.example.task_manager;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
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
    TextView no_data;
    ImageView no_data_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_list);
        myDB = new MyDatabaseHelper(TaskList.this);
        setUpAppBar();
        setupTaskList();
        displayItems();

        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void setupTaskList() {
        no_data = findViewById(R.id.no_data);
        no_data_img = findViewById(R.id.no_data_img);
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            no_data.setVisibility(View.VISIBLE);
            no_data_img.setVisibility(View.VISIBLE);
            Toast.makeText(this, "No data. ", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                TaskModel task = new TaskModel(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                Log.d("MyApp", "setupTaskList: " + task.toString());
                tasks.add(task);
            }
            no_data.setVisibility(View.GONE);
            no_data_img.setVisibility(View.GONE);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.task_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.actionDeleteAll) {
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to delete all tasks?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(TaskList.this);
                myDB.deleteAllTasks();
                Intent intent = new Intent(TaskList.this, TaskList.class);
                startActivity(intent);
                recreate();
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
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