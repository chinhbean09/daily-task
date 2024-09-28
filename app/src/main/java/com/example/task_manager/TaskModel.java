package com.example.task_manager;

import java.io.Serializable;

public class TaskModel implements Serializable {
    String name;
    String time;
    String location;
    String description;

    public TaskModel(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
