package com.example.task_manager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TaskDetail extends AppCompatActivity {
    EditText task_name, task_time, task_location, task_description;
    String id, name, time, location, description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_detail);
        setUpAppBar();

        task_name = findViewById(R.id.editTextText2);
        task_time = findViewById(R.id.editTextText3);
        task_location = findViewById(R.id.editTextText4);
        task_description = findViewById(R.id.editTextText5);
        TaskModel model = null;
        Bundle extras = getIntent().getExtras();
        model = (TaskModel) extras.getSerializable("task");
        if (model != null) {
            setUpIntentData(model);
        } else {
            Toast.makeText(this, "No data. ", Toast.LENGTH_SHORT).show();
        }
        setUpUpdateBtn(model);
    }

    private void setUpIntentData(TaskModel model) {
        task_name.setText(model.getName());
        task_time.setText(model.getTime());
        task_location.setText(model.getLocation());
        task_description.setText(model.getDescription());
    }

    private void setUpAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }


    private void setUpUpdateBtn(TaskModel model) {
        Button updateBtn = findViewById(R.id.updateButton);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = model.getId();
                name = task_name.getText().toString();
                time = task_time.getText().toString();
                location = task_location.getText().toString();
                description = task_description.getText().toString();
                MyDatabaseHelper myDB = new MyDatabaseHelper(TaskDetail.this);
                myDB.updateTask(id, name, time, location, description);
            }
        });
    }


    private void setUpCancelBtn() {
        Button cancelBtn = findViewById(R.id.cancelButton);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}