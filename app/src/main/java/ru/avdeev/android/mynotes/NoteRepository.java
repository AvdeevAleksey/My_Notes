package ru.avdeev.android.mynotes;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteRepository {
    @Query("SELECT * FROM note WHERE title = :title") default NoteData getByTitle(String title) {
        return noteDAO().getByTitle(title);
    }
    @Query("SELECT * FROM note") default List<NoteData> getAll() {
        return noteDAO().getAll();
    }

    @Insert default void saveNote(NoteData note) {
        noteDAO().saveNote(note);
    }
    @Update default void updateNote(NoteData note) {
        noteDAO().updateNote(note);
    }
    @Delete default void deleteByTitle(String title) {
        noteDAO().deleteByTitle(title);
    }

    default NoteRepository noteDAO() {
        AppDatabase db = NewNoteActivity.getInstance().getDatabase();
        NoteRepository noteDao = db.NoteDataDao();
        return noteDao;
    }
}
