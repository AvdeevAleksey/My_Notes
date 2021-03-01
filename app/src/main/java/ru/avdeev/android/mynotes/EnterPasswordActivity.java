package ru.avdeev.android.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnterPasswordActivity extends AppCompatActivity implements View.OnClickListener, Keystore {

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFor;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;
    Button btnBackspace;
    TextView errorTextView;
    ImageView firstCircle;
    ImageView secondCircle;
    ImageView thirdCircle;
    ImageView fourthCircle;
    public static int i = 0;
    private String enteredPin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFor = findViewById(R.id.btnFor);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnBackspace = findViewById(R.id.btnBackspace);
        errorTextView = findViewById(R.id.errorTextView);
        firstCircle = findViewById(R.id.firstImageView);
        secondCircle = findViewById(R.id.secondImageView);
        thirdCircle = findViewById(R.id.thirdImageView);
        fourthCircle = findViewById(R.id.fourthImageView);
        btnZero.setOnClickListener(EnterPasswordActivity.this);
        btnOne.setOnClickListener(EnterPasswordActivity.this);
        btnTwo.setOnClickListener(EnterPasswordActivity.this);
        btnThree.setOnClickListener(EnterPasswordActivity.this);
        btnFor.setOnClickListener(EnterPasswordActivity.this);
        btnFive.setOnClickListener(EnterPasswordActivity.this);
        btnSix.setOnClickListener(EnterPasswordActivity.this);
        btnSeven.setOnClickListener(EnterPasswordActivity.this);
        btnEight.setOnClickListener(EnterPasswordActivity.this);
        btnNine.setOnClickListener(EnterPasswordActivity.this);
        btnBackspace.setOnClickListener(EnterPasswordActivity.this);

    }

    public void onClick(View view) {
        if (i==0) {
            errorTextView.setText("");
        }
        switch (view.getId()) {
            case R.id.btnZero: {
                i=i+1;
                printMyText(R.string.button_zero);
                inputAttempt();
                break;
            }
            case R.id.btnOne: {
                i=i+1;
                printMyText(R.string.button_one);
                inputAttempt();
                break;
            }
            case R.id.btnTwo: {
                i=i+1;
                printMyText(R.string.button_two);
                inputAttempt();
                break;
            }
            case R.id.btnThree: {
                i=i+1;
                printMyText(R.string.button_three);
                inputAttempt();
                break;
            }
            case R.id.btnFor: {
                i=i+1;
                printMyText(R.string.button_for);
                inputAttempt();
                break;
            }
            case R.id.btnFive: {
                i=i+1;
                printMyText(R.string.button_five);
                inputAttempt();
                break;
            }
            case R.id.btnSix: {
                i=i+1;
                printMyText(R.string.button_six);
                inputAttempt();
                break;
            }
            case R.id.btnSeven: {
                i=i+1;
                printMyText(R.string.button_seven);
                inputAttempt();
                break;
            }
            case R.id.btnEight: {
                i=i+1;
                printMyText(R.string.button_eight);
                inputAttempt();
                break;
            }
            case R.id.btnNine: {
                i=i+1;
                printMyText(R.string.button_nine);
                inputAttempt();
                break;
            }
            case R.id.btnBackspace: {
                if (i<1){
                    Toster.showMyMessage(R.string.invalid_input, EnterPasswordActivity.this);
                } else {
//                    errorTextView.setText(errorTextView.getText().toString().substring(0, errorTextView.getText().toString().length() - 1));
                    i = i - 1;
                    inputAttempt();
                }
                break;
            }
            default: {
                Toster.showMyMessage(R.string.invalid_input, EnterPasswordActivity.this);
            }
        }
    }
    // Поменять действия этой процедуры на сохранение в строковую переменную вводимых символов
    public void printMyText(int id) {
        enteredPin = enteredPin + getString(id);
    }

    public void inputAttempt() {
        switch (i) {
            case 0: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                break;
            }
            case 1: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                break;
            }
            case 2: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                break;
            }
            case 3: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                break;
            }
            case 4: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24_another);
                checkMyPin();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + i);

        }
    }

    public void checkMyPin() {
        // В этом блоке проверяем пин-код
        if (checkPin(enteredPin)) {
            Intent intent = new Intent(EnterPasswordActivity.this, NotesActivity.class);
            startActivity(intent);
//            Toster.showMyMessage(R.string.correct_pin, this);
        } else {
            errorTextView.setText(R.string.error_pin);
            enteredPin = "";
            i = 0;
            inputAttempt();
        }
    }

    @Override
    public boolean checkPin(String pinCode) {
        return Keystore.super.checkPin(pinCode);
    }

    @Override
    public String loadPinCode() {
        return Keystore.super.loadPinCode();
    }
}
