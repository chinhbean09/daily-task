package com.example.task_manager;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<TaskModel> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpAddTaskButton();
        setUpTimePickerButton();
    }

    private void setUpAddTaskButton() {
        EditText taskNameET = findViewById(R.id.taskNameEditText);
        TextView selectedTimeTV = findViewById(R.id.idTVSelectedTime);
        Button addTaskBtn = findViewById(R.id.addTaskButton);

        // Retrieve the task list if returning from SecondActivity
//        Intent i = getIntent();
//        if (i.hasExtra("taskList")) {
//            tasks = (ArrayList<TaskModel>) i.getSerializableExtra("taskList");
//        }

        addTaskBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name = taskNameET.getText().toString();
                String time = selectedTimeTV.getText().toString();
                if (name.isEmpty() || time.isEmpty()) {
                    Snackbar.make(view, "Both fields must be filled!", Snackbar.LENGTH_LONG).show();
                } else {
//                    TaskModel task = new TaskModel(name, time);
//                    tasks.add(task);
//                    Intent intent = new Intent(getApplicationContext(), TaskList.class);
//                    intent.putExtra("taskList", tasks);
//                    startActivity(intent);
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