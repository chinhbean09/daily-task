package com.example.task_manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private Context context;
    private ArrayList<TaskModel> taskList;
    private SelectListener listener;
    Activity activity;

    public TaskRecyclerViewAdapter(Activity activity, Context context, ArrayList<TaskModel> taskList, SelectListener listener) {
        this.activity = activity;
        this.context = context;
        this.taskList = taskList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.taskName.setText(taskList.get(position).getName());
        holder.taskTime.setText(taskList.get(position).getTime());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TaskDetail.class);
                TaskModel model = (TaskModel) taskList.get(position);
                intent.putExtra("task", model);
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
