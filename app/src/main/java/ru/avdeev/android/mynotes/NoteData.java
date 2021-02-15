package ru.avdeev.android.mynotes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteData {

    @PrimaryKey
    private String title;
    private String subtitle;
    private String deadline;

    public NoteData(String title, String subtitle, String deadline) {
        this.title = title;
        this.subtitle = subtitle;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
