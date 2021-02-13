package ru.avdeev.android.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.File;
import java.util.Map;
import java.util.Set;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, Keystore {

    EditText newPinEditText;
    Button btnSavePinCode;
    ImageButton btnViewHidePin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        newPinEditText = findViewById(R.id.newPinEditText);
        btnSavePinCode = findViewById(R.id.btnSavePinCode);
        btnViewHidePin = findViewById(R.id.btnViewHidePin);
        btnSavePinCode.setOnClickListener(this);
        btnViewHidePin.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSavePinCode: {
                //  Здесь код по сохранению пин-кода, возвращению в NotesActivity,
                //  пересоздание списка, вывод сообщения об успешном сохранении.
                savePinCode(newPinEditText.getText().toString());
            }
            case R.id.btnViewHidePin: {
                //  Пока не придумал как будет работать.
            }
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        //onBackPressed();

        //  Если пинкода нет, то перехода в NotesActivity не будет до его набора

        savePinCode(newPinEditText.getText().toString());

        if (hasPin()) {
            Intent intent = new Intent(SettingsActivity.this, NotesActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, ?> getAll() {
        return null;
    }

    @Nullable
    @Override
    public String getString(String s, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String s, @Nullable Set<String> set) {
        return null;
    }

    @Override
    public int getInt(String s, int i) {
        return 0;
    }

    @Override
    public long getLong(String s, long l) {
        return 0;
    }

    @Override
    public float getFloat(String s, float v) {
        return 0;
    }

    @Override
    public boolean getBoolean(String s, boolean b) {
        return false;
    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public Editor edit() {
        return null;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

    }

    @Override
    public boolean hasPin() {
        return false;
    }

    @Override
    public boolean checkPin(String pinCode) {
        return false;
    }

    @Override
    public void savePinCode(String pinCode) {

    }

    @Override
    public String loadPinCode() {
        return null;
    }
}
