package ru.avdeev.android.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static ru.avdeev.android.mynotes.MainActivity.pin;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notesSave: {
                //  Здесь код по сохранению заметки, возвращению в NotesActivity,
                //  пересоздание списка, вывод сообщения об успешном сохранении.
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //onBackPressed();

        //  Если пинкода нет, то перехода в NotesActivity не будет до его набора

        if (pin) {
            Intent intent = new Intent(SettingsActivity.this, NotesActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
