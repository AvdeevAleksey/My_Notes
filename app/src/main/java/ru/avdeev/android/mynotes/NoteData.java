package ru.avdeev.android.mynotes;

import android.provider.ContactsContract;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteData {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String body;
    private long deadline;

    public NoteData() {
    }

    public NoteData(int id, String title, String body, long deadline) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }
}
