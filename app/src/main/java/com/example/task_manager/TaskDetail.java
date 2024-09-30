package com.example.task_manager;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_detail);
        setUpAppBar();
        EditText name = findViewById(R.id.editTextText2);
        EditText time = findViewById(R.id.editTextText3);
        EditText location = findViewById(R.id.editTextText4);
        EditText description = findViewById(R.id.editTextText5);
        TaskModel model = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            model = (TaskModel) extras.getSerializable("task");
        }
        name.setText(model.getName());
        time.setText(model.getTime());
    }


    private void setUpAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }


    private void setUpUpdateBtn() {

    }


    private void setUpDeleteBtn() {

    }
}