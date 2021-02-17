package ru.avdeev.android.mynotes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NoteData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteRepository NoteDataDao();
}
