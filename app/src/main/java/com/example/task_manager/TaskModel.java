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

    public TaskModel(String name, String time, String location, String description) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
