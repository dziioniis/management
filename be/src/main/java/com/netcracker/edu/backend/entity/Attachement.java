package com.netcracker.edu.backend.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;


@Entity
@Table(name = "attachement")
public class Attachement {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String url;
    private long task;

    public Attachement() {
    }

    public Attachement(String name, String url, long task) {
        this.name = name;
        this.url = url;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Attachement{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", task=" + task +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTask() {
        return task;
    }

    public void setTask(long task) {
        this.task = task;
    }
}
