package com.example.calculator2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView calculatorScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);
        initButtons();
    }
    private void initButtons() {
        Calculator buttonClickListener = new Calculator (calculatorScreen, this);

        Button button0 = findViewById(R.id._0);
        Button button1 = findViewById(R.id._1);
        Button button2 = findViewById(R.id._2);
        Button button3 = findViewById(R.id._3);
        Button button4 = findViewById(R.id._4);
        Button button5 = findViewById(R.id._5);
        Button button6 = findViewById(R.id._6);
        Button button7 = findViewById(R.id._7);
        Button button8 = findViewById(R.id._8);
        Button button9 = findViewById(R.id._9);
        Button buttonPlus = findViewById(R.id.plus);
        Button buttonMinus = findViewById(R.id.minus);
        Button buttonMultiplication = findViewById(R.id.multiplication);
        Button buttonDivision = findViewById(R.id.division);
        Button buttonEqual = findViewById(R.id.equal);
        Button buttonRoot = findViewById(R.id.root);
        Button buttonBack = findViewById(R.id.back);
        Button buttonC = findViewById(R.id.c);
        Button buttonPlusMinus = findViewById(R.id.plusMinus);

        buttonClickListener.setButtonClickListeners(button0, getString(R.string._0));
        buttonClickListener.setButtonClickListeners(button1, getString(R.string._1));
        buttonClickListener.setButtonClickListeners(button2, getString(R.string._2));
        buttonClickListener.setButtonClickListeners(button3, getString(R.string._3));
        buttonClickListener.setButtonClickListeners(button4, getString(R.string._4));
        buttonClickListener.setButtonClickListeners(button5, getString(R.string._5));
        buttonClickListener.setButtonClickListeners(button6, getString(R.string._6));
        buttonClickListener.setButtonClickListeners(button7, getString(R.string._7));
        buttonClickListener.setButtonClickListeners(button8, getString(R.string._8));
        buttonClickListener.setButtonClickListeners(button9, getString(R.string._9));
        buttonClickListener.setButtonClickListeners(buttonPlus, getString(R.string.plus));
        buttonClickListener.setButtonClickListeners(buttonMinus, getString(R.string.minus));
        buttonClickListener.setButtonClickListeners(buttonMultiplication, getString(R.string.multiply));
        buttonClickListener.setButtonClickListeners(buttonDivision, getString(R.string.divided));
        buttonClickListener.setButtonClickListeners(buttonEqual, getString(R.string.equal));
        buttonClickListener.setButtonClickListeners(buttonRoot, getString(R.string.root));
        buttonClickListener.setButtonClickListeners(buttonC, getString(R.string.c));
        buttonClickListener.setButtonClickListeners(buttonBack, getString(R.string.backArrow));
        buttonClickListener.setButtonClickListeners(buttonPlusMinus, getString(R.string.plusMinus));

    }
}