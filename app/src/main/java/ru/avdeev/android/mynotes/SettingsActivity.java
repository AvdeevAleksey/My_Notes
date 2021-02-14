package ru.avdeev.android.mynotes;

import android.content.Context;
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
                Intent intent = new Intent(SettingsActivity.this, NotesActivity.class);
                startActivity(intent);
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
            Toster.showMyMessage(R.string.new_pin_saved,(Context) this);
            Intent intent = new Intent(SettingsActivity.this, NotesActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    public void savePinCode(String pinCode) {
        Keystore.super.savePinCode(pinCode);
    }
}
