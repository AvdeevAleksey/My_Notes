package ru.avdeev.android.mynotes;

import java.util.List;

public interface NoteRepository {
    NoteData getNoteById(String id);
    List<NoteData> getNotes();
    void saveNote(NoteData note);
    void deleteById(String id);
}
