package com.example.exercise3;

//region import
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//endregion

public class CalcController {
    //region properties
    @FXML private TextField txtResult;
    private double enteredNumber = 0;
    private String actionName = "";
    private boolean awaitingOperation = false; // Flag to check that calculator is waiting for an operation
    private boolean enteringDigit = false; // Flag to check whether the user is currently entering a digit
    //endregion

    //region methods
    //Button click method
    @FXML
    private void btnClick(ActionEvent event)
    {
        String buttonName = ((Button) event.getTarget()).getId();

        // Check if any Error occurred
        if (txtResult.getText().equals("ERR"))
        {
            resetCalculator();
            return;
        }

        if (buttonName.startsWith("btnNum"))
        {
            handleNumberButton(buttonName.substring(6));
        }
        else if (buttonName.startsWith("btnOpr"))
        {
            handleOperationButton(buttonName);
        } else {
            switch (buttonName) {
                case "btnReset":
                    resetCalculator();
                    break;
                case "btnDecimalPoint":
                    handleDecimalPoint();
                    break;
                case "btnBackspace":
                    handleBackspace();
                    break;
                case "btnEqual":
                    performCalculation();
                    break;
            }
        }
    }

    // Method to reset the calculator
    private void resetCalculator()
    {
        txtResult.setText("0");
        enteredNumber = 0;
        actionName = "";
        awaitingOperation = enteringDigit = false;
    }

    // Method to handle when numeric button is clicked
    private void handleNumberButton(String clickedNumber)
    {
        if (enteringDigit && !awaitingOperation)
        {
            txtResult.setText(txtResult.getText() + clickedNumber);
        }
        else {
            txtResult.setText(clickedNumber);
            enteringDigit = true;
            awaitingOperation = false;
        }
    }

    // Method to handle when operation button is clicked
    private void handleOperationButton(String buttonName)
    {
        if (enteringDigit && !awaitingOperation)
        {
            actionName = buttonName.substring(6);
            enteredNumber = parseDouble(txtResult.getText());
            enteringDigit = false;
            awaitingOperation = true;
        }
        else if (awaitingOperation) {
            actionName = buttonName.substring(6);
        }
    }

    // Method to handle decimal points
    private void handleDecimalPoint()
    {
        if (!txtResult.getText().contains(".") && !awaitingOperation)
        {
            txtResult.setText(txtResult.getText() + ".");
            enteringDigit = true;
        }
        else if (awaitingOperation) {
            txtResult.setText("0.");
            enteringDigit = true;
            awaitingOperation = false;
        }
    }

    // Method to handle Backspace button click
    private void handleBackspace()
    {
        String currentText = txtResult.getText();
        if (!currentText.isEmpty())
        {
            txtResult.setText(currentText.substring(0, currentText.length() - 1));
            if (txtResult.getText().isEmpty()) {
                txtResult.setText("0");
                enteringDigit = false;
            }
        }
    }

    // Method to perform calculation
    private void performCalculation()
    {
        DecimalFormat format = new DecimalFormat("0.######");
        double result = computeSymbol(enteredNumber, actionName, parseDouble(txtResult.getText()));
        System.out.println("Result: " + result);
        txtResult.setText(format.format(result));
        enteredNumber = result;
        awaitingOperation = true;
        enteringDigit = false;
    }

    // Parse String to Double
    private double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            txtResult.setText("ERR");
            return 0;
        }
    }

    // Method to compute the maths operation symbol
    public double computeSymbol(double value1, String symbol, double value2)
    {
        switch (symbol) {
            case "Plus":
                return value1 + value2;
            case "Minus":
                return value1 - value2;
            case "Multiply":
                return value1 * value2;
            case "Divide":
                if (value2 != 0) {
                    return value1 / value2;
                } else {
                    txtResult.setText("ERR");
                    return 0;
                }
            default:
                return 0;
        }
    }
    //endregion
}
