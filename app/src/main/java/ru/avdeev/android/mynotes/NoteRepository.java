package ru.avdeev.android.mynotes;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

@Dao
public interface NoteRepository{

    @Query("SELECT * FROM NoteData WHERE id = :id")
    NoteData getById(int id);
        @Query("SELECT * FROM NoteData ORDER BY deadline ASC")
        List<NoteData> getAll();
        @Insert void saveNote(NoteData note);
        @Update void updateNote(NoteData note);
        @Query("DELETE FROM NoteData WHERE id = :id")
        void deleteById(int id);
//        @RawQuery List<NoteData> runtimeQuery(SupportSQLiteQuery sortQuery);
//        @Query("SELECT * FROM NoteData ORDER BY :orderBY ASC")
//        List<NoteData> sortedFind(String orderBY);
}
