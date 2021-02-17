package ru.avdeev.android.mynotes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteData {

    @PrimaryKey
    private String title;
    private String body;
    private String deadline;

    public NoteData() {
    }

    public NoteData(String title, String body, String deadline) {
        this.title = title;
        this.body = body;
        this.deadline = deadline;
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
