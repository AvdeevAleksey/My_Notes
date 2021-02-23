package ru.avdeev.android.mynotes;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    private static NoteRepository noteRepository;

    public static NoteRepository getNoteRepository() {
        return noteRepository;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        noteRepository = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build()
                .NoteDataDao();
    }
}
