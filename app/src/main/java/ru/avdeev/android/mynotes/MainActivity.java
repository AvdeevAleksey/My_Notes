package ru.avdeev.android.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        btnZero.setOnClickListener(MainActivity.this);
        btnOne.setOnClickListener(MainActivity.this);
        btnTwo.setOnClickListener(MainActivity.this);
        btnThree.setOnClickListener(MainActivity.this);
        btnFor.setOnClickListener(MainActivity.this);
        btnFive.setOnClickListener(MainActivity.this);
        btnSix.setOnClickListener(MainActivity.this);
        btnSeven.setOnClickListener(MainActivity.this);
        btnEight.setOnClickListener(MainActivity.this);
        btnNine.setOnClickListener(MainActivity.this);
        btnBackspace.setOnClickListener(MainActivity.this);

    }

    public void onClick(View view) {
        if (i==0) {
            errorTextView.setText("");
        }
        switch (view.getId()) {
            case R.id.btnZero: {
                printMyText(R.string.button_zero);
                inputAttempt();
                break;
            }
            case R.id.btnOne: {
                printMyText(R.string.button_one);
                inputAttempt();
                break;
            }
            case R.id.btnTwo: {
                printMyText(R.string.button_two);
                inputAttempt();
                break;
            }
            case R.id.btnThree: {
                printMyText(R.string.button_three);
                inputAttempt();
                break;
            }
            case R.id.btnFor: {
                printMyText(R.string.button_for);
                inputAttempt();
                break;
            }
            case R.id.btnFive: {
                printMyText(R.string.button_five);
                inputAttempt();
                break;
            }
            case R.id.btnSix: {
                printMyText(R.string.button_six);
                inputAttempt();
                break;
            }
            case R.id.btnSeven: {
                printMyText(R.string.button_seven);
                inputAttempt();
                break;
            }
            case R.id.btnEight: {
                printMyText(R.string.button_eight);
                inputAttempt();
                break;
            }
            case R.id.btnNine: {
                printMyText(R.string.button_nine);
                inputAttempt();
                break;
            }
            case R.id.btnBackspace: {
                if (i<2){
                    showMyMessage(R.string.invalid_input, MainActivity.this);
                } else {
                    errorTextView.setText(errorTextView.getText().toString().substring(0, errorTextView.getText().toString().length() - 1));
                    i = i - 2;
                    inputAttempt();
                }
                break;
            }
            default: {
                showMyMessage(R.string.invalid_input, MainActivity.this);
            }
        }


    }

    public void printMyText(int id) {
        i=i+1;
        errorTextView.setText(errorTextView.getText().toString() + getString(id));

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
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                break;
            }
            case 2: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                break;
            }
            case 3: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24);
                break;
            }
            case 4: {
                firstCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                secondCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                thirdCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                fourthCircle.setImageResource(R.drawable.ic_round_brightness_1_24_yallow);
                checkMyPin();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + i);

        }
    }

    public void checkMyPin() {
        if (errorTextView.getText().toString().equals("1111")) {
            errorTextView.setText("Успешный логин");
        } else {
            errorTextView.setText("");
            printMyText(R.string.error_pin);
            i = 0;
            inputAttempt();
        }
    }
    public static void showMyMessage(int massage, Context context) {
        String text = context.getString(massage);
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(context, biggerText, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}