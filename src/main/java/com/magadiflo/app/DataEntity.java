package com.magadiflo.app;

public class DataEntity {

    private long userId;
    private long id;
    private String title;
    private boolean completed;

    public DataEntity() {
    }

    public DataEntity(long userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public DataEntity(long userId, long id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
