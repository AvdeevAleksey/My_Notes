package ru.avdeev.android.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity implements ItemClickListener{

    ArrayList<NoteData> notes = new ArrayList<>();
    NotesDataAdapter adapter;
    RecyclerView recyclerView;
    FloatingActionButton fab;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);

        setInitialData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesDataAdapter(this, notes);

        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this, NewNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setInitialData() {

        String query = "SELECT * FROM NoteData ORDER BY deadline ASC";
        List<NoteData> all = App.getNoteRepository().runtimeQuery(new SimpleSQLiteQuery(query));
        if (!all.isEmpty()) {
            notes.addAll(all);
        } else {
            // TODO Вместо тоста лучше вьюшку
            Toster.showMyMessage(R.string.empty_notes, this);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notesSettings:
                Intent intent = new Intent(NotesActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,
                "Номер id адаптера: " + adapter.getItem(position).getId()
                        + "\nНомер id заметки: " + notes.get(position).getId()
                + "\nЗаголовок: " + notes.get(position).getTitle()
                + "\nстрочка " + position,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, NewNoteActivity.class);
        intent.putExtra("note", adapter.getItem(position).getId());
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {
        adapter.removeNote(position);
    }
}
