package com.modildev.mytestapplication1;

public class Notepad {
    private int id;
    private String comment;

    public Notepad(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Notepad(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
