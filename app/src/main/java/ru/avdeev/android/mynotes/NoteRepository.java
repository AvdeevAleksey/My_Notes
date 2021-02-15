package ru.avdeev.android.mynotes;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface NoteRepository {
    NoteData getNoteById(String id);
    List<NoteData> getNotes();

    @Insert void saveNote(NoteData note);
    @Delete void deleteById(String id);

//    @Entity
//    public class Person {
//        @PrimaryKey String name;
//        int age;
//        String favoriteColor;
//    }
//    // Получение всех Person из бд
//    @Query("SELECT * FROM person")
//    List<Person> getAllPeople();
//
//    // Получение всех Person из бд с условием
//    @Query("SELECT * FROM person WHERE favoriteColor LIKE :color")
//    List<Person> getAllPeopleWithFavoriteColor(String color);
//
//    @Database(entities = {Person.class /*, AnotherEntityType.class, AThirdEntityType.class */}, version = 1)
//    public abstract class AppDatabase extends RoomDatabase {
//        public abstract PersonDao getPersonDao();
//    }
//
//    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//            AppDatabase.class, "populus-database").build();
//    List<Person> everyone = db.getPersonDao().getAllPeople();
//
//    https://habr.com/ru/post/336196/
}
