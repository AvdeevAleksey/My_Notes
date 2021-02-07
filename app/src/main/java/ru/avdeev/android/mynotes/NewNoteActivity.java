package ru.avdeev.android.mynotes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NewNoteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextDateTime;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_note_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editTextDateTime = (EditText) findViewById(R.id.deadlineEditText);
        editTextDateTime.setOnClickListener(this);
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
            case R.id.deadlineEditText: {
                //  Здесь код возвращает текущую дату и время для дедлайна.
                //  Как-то надо впихнуть этот код сюда
                //
                //  Calendar todayCalendar = Calendar.getInstance();
                //      datePickerDialog = new DatePickerDialog(
                //        this,
                //        onDateSet,
                //        todayCalendar.get(Calendar.YEAR),
                //        todayCalendar.get(Calendar.MONTH),
                //        todayCalendar.get(Calendar.DAY_OF_MONTH)
                //      );
                //  datePickerDialog.show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
