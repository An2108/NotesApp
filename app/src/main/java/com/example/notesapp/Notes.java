package com.example.notesapp;

public class Notes {
    private long id;
    private  String title;
    private  String note;
    private  String date;
    private Boolean pinned;

    public Notes(){
        this.id = 0;
        this.title = "";
        this.note ="";
        this.date = "";
        this.pinned = false;
    }

    public Notes(long id, String title, String note, String date, Boolean pinned) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.date = date;
        this.pinned = pinned;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                ", pinned=" + pinned +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }

    public Boolean getPinned() {
        return pinned;
    }
}

