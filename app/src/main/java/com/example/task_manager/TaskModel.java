package com.example.task_manager;

import java.io.Serializable;

public class TaskModel implements Serializable {
    private String id;
    private String name;
    private String time;
    private String location;
    private String description;

    public TaskModel(String id, String name, String time, String location, String description) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.location = location;
        this.description = description;
    }

    public TaskModel(String name, String time) {
        this.name = name;
        this.time = time;
    }


    public TaskModel(String id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
