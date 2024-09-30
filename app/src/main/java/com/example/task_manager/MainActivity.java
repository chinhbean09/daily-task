package com.example.task_manager;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpAppBar();
        setUpAddTaskButton();
        setUpTimePickerButton();
    }

    private void setUpAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setUpAddTaskButton() {
        EditText taskNameET = findViewById(R.id.taskNameEditText);
        TextView selectedTimeTV = findViewById(R.id.idTVSelectedTime);
        Button addTaskBtn = findViewById(R.id.addTaskButton);
        addTaskBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB;
                String name = taskNameET.getText().toString().trim();
                String time = selectedTimeTV.getText().toString().trim();
                if (name.isEmpty() || time.isEmpty()) {
                    Snackbar.make(view, "Both fields must be filled!", Snackbar.LENGTH_LONG).show();
                } else {
                    try {
                        myDB = new MyDatabaseHelper(MainActivity.this);
                        myDB.addTask(name, time);
                        Intent intent = new Intent(MainActivity.this, TaskList.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        Log.e("MyApp", "onClick: ", e);
                    }
                }
            }
        });
    }


    private void setUpTimePickerButton() {
        Button pickTimeBtn = findViewById(R.id.timePickerButton);
        TextView selectedTimeTV = findViewById(R.id.idTVSelectedTime);
        pickTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // on below line we are getting the
                // instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting our hour, minute.
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this
                        , new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTimeTV.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
                timePickerDialog.show();
            }
        });
    }
}