package ru.avdeev.android.mynotes;

public class NoteData {

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
}
