package ru.avdeev.android.mynotes;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteRepository{
    @Query("SELECT * FROM note WHERE id = :id") default NoteData getById(int id) {
        return noteDAO().getById(id);
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
    @Delete default void deleteById(int id) {
        noteDAO().deleteById(id);
    }

    default NoteRepository noteDAO() {
        AppDatabase db = NewNoteActivity.getInstance().getDatabase();
        NoteRepository noteDao = db.NoteDataDao();
        return noteDao;
    }
}
