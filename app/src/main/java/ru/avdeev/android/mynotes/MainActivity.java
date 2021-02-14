package ru.avdeev.android.mynotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity implements Keystore {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isTherePin();
    }

    private void isTherePin() {
        //  Вместо следующей строки запрос на наличие пин-кода
        if (hasPin()) {
            Intent intent = new Intent(MainActivity.this, EnterPasswordActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public String getPackageName() {
        return super.getPackageName();
    }
}