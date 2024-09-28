package com.example.task_manager;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    public TextView taskName, taskTime;
    public CardView cardView;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskName = itemView.findViewById(R.id.taskName);
        taskTime = itemView.findViewById(R.id.taskTime);
        cardView = itemView.findViewById(R.id.card_container);
    }
}
