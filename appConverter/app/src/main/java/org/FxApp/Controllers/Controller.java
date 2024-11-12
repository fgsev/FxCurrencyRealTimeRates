package org.FxApp.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private ComboBox<String> ComboBoxCurrencyFirst;

    @FXML
    private ComboBox<String> ComboBoxCurrencySecond;

    @FXML
    private TextArea currentCurrencies;

    public void initialize() {
        ComboBoxCurrencyFirst.getItems().addAll("PLN", "USD");
        ComboBoxCurrencySecond.getItems().addAll("PLN", "USD");
    }

    public void togleCurrencyIfEqaul() {
        String firstSelectedValue = ComboBoxCurrencyFirst.getValue();
        String secondSelectedValue = ComboBoxCurrencySecond.getValue();

        if ("PLN".equals(firstSelectedValue) && "PLN".equals(secondSelectedValue)) {
            if (ComboBoxCurrencyFirst.isFocused()) {
                ComboBoxCurrencySecond.setValue("USD");
            } else {
                ComboBoxCurrencyFirst.setValue("USD");
            }
        } else if ("USD".equals(firstSelectedValue) && "USD".equals(secondSelectedValue)) {
            if (ComboBoxCurrencyFirst.isFocused()) {
                ComboBoxCurrencySecond.setValue("PLN");
            } else {
                ComboBoxCurrencyFirst.setValue("PLN");
            }
        }
    }

//    @FXML
//    public void displayCurrencyFromAPI(){
//
//    }

}

