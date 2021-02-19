package ru.avdeev.android.mynotes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteData {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String body;
    private String deadline;

    public NoteData() {
    }

    public NoteData(int id) {
        this.id = id;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
