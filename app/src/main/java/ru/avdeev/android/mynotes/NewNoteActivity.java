package ru.avdeev.android.mynotes;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import java.util.Calendar;

public class NewNoteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText titleEditText;
    EditText bodyEditText;
    EditText editTextDateTime;
    ImageButton buttonCalendar;
    CheckBox deadlineChkBox;
    Calendar todayCalendar = Calendar.getInstance();

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
        buttonCalendar = (ImageButton) findViewById(R.id.btnCalendar);
        deadlineChkBox = (CheckBox) findViewById(R.id.deadlineCheckBox);
        titleEditText = (EditText) findViewById(R.id.titleNotes);
        bodyEditText = (EditText) findViewById(R.id.bodyNotes);
        editTextDateTime.setEnabled(false);
        buttonCalendar.setEnabled(false);

        deadlineChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    editTextDateTime.setEnabled(true);
                    buttonCalendar.setEnabled(true);
                    setInitialDateTime();
                    editTextDateTime.setOnClickListener(NewNoteActivity.this::onClick);
                    buttonCalendar.setOnClickListener(NewNoteActivity.this::onClick);
                } else {
                    editTextDateTime.setText(R.string.deadline);
                    editTextDateTime.setEnabled(false);
                    buttonCalendar.setEnabled(false);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.deadlineEditText: {
                setInitialDateTime();
                break;
            }
            case R.id.btnCalendar: {
                setTime(view);
                setDate(view);
                break;
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notesSave: {
                //  Здесь код по сохранению заметки, возвращение в NotesActivity,
                //  пересоздание списка, вывод сообщения об успешном сохранении.
                NoteData note = new NoteData();
                note.setTitle(titleEditText.getText().toString());
                note.setBody(bodyEditText.getText().toString());
                if (deadlineChkBox.isChecked()) {
                    note.setDeadline(editTextDateTime.getText().toString());
                } else {
                    note.setDeadline("");
                }
                App.getNoteRepository().saveNote(note);
                Intent intent = new Intent(NewNoteActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setInitialDateTime() {
        editTextDateTime.setText(DateUtils.formatDateTime(this,
                todayCalendar.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }

    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            todayCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            todayCalendar.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            todayCalendar.set(Calendar.YEAR, year);
            todayCalendar.set(Calendar.MONTH, monthOfYear);
            todayCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };

    // отображаем диалоговое окно для выбора даты
    public void setDate(View v) {
        new DatePickerDialog(NewNoteActivity.this, d,
                todayCalendar.get(Calendar.YEAR),
                todayCalendar.get(Calendar.MONTH),
                todayCalendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {
        new TimePickerDialog(NewNoteActivity.this, t,
                todayCalendar.get(Calendar.HOUR_OF_DAY),
                todayCalendar.get(Calendar.MINUTE), true)
                .show();
    }
}
