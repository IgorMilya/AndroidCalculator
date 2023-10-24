package com.example.calculator2;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator {
    private String currentInput = "";
    private String currentOperation = "";
    private final TextView calculatorScreen;
    private final Context context;
    private double memory = 0;


    public Calculator(TextView calculatorScreen, Context context) {
        this.calculatorScreen = calculatorScreen;
        this.context = context;
    }

    public void setButtonClickListeners(final Button button, final String buttonText) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isArithmeticOperation(buttonText)) {
                    handleArithmeticOperation(buttonText);
                } else if (buttonText.equals(context.getString(R.string.equal))) {
                    calculateResult();
                } else if (buttonText.equals(context.getString(R.string.backArrow))) {
                    handleBack();
                } else if (buttonText.equals(context.getString(R.string.c))) {
                    handleClear();
                } else if (buttonText.equals(context.getString(R.string.plusMinus))) {
                    handleSignChange();
                } else {
                    currentInput += buttonText;
                }
                updateCalculatorScreen();
            }
        });
    }

    private void handleBack() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
        }
    }

    private void handleClear() {
        currentInput = "";
        currentOperation = "";
        memory = 0;
    }

    private void handleSignChange() {
        if (!currentInput.isEmpty()) {
            double value = Double.parseDouble(currentInput);
            value = -value;
            currentInput = formatNumber(value);
        }
    }

    private boolean isArithmeticOperation(String buttonText) {
        return "+".equals(buttonText) || "-".equals(buttonText) ||
                "*".equals(buttonText) || "/".equals(buttonText) ||
                "√".equals(buttonText);
    }

    private void handleArithmeticOperation(String operation) {
        if (!currentInput.isEmpty()) {
            if (currentOperation.isEmpty()) {
                memory = Double.parseDouble(currentInput);
            } else {
                double secondOperand = Double.parseDouble(currentInput);
                performOperation(currentOperation, secondOperand);
            }
            currentOperation = operation;

            isRoot(operation);
        }
    }

    private void isRoot(String operation) {
        if ("√".equals(operation)) {
            if (memory >= 0) {
                currentInput = formatNumber(Math.sqrt(memory));
            } else {
                showError("Cannot calculate square root of a negative number.");
                return;
            }
            updateCalculatorScreen();
        } else {
            currentInput = "";
        }
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !currentOperation.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            performOperation(currentOperation, secondOperand);
            currentInput = formatNumber(memory);
            currentOperation = "";
        }
    }

    private void performOperation(String operation, double secondOperand) {
        switch (operation) {
            case "+":
                memory += secondOperand;
                break;
            case "-":
                memory -= secondOperand;
                break;
            case "*":
                memory *= secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    memory /= secondOperand;
                } else {
                    showError("Cannot divide by zero.");
                }
                break;
            case "√":
                if (memory >= 0) {
                    memory = Math.sqrt(memory);
                } else {
                    showError("Cannot calculate square root of a negative number.");
                }
                break;
            default:
                break;
        }
    }


    private String formatNumber(double number) {
        if (number == (int) number) {
            return String.valueOf((int) number);
        } else {
            return Double.toString(number);
        }
    }

    private void showError(String errorMessage) {
        Toast.makeText(context.getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void updateCalculatorScreen() {
        calculatorScreen.setText(currentInput);
    }
}
