package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {


    @FXML
    private TextField first_input;
    @FXML
    private TextField second_input;
    @FXML
    private Label number;

    private String operation;
    @FXML
    protected void Onplus(ActionEvent actionEvent) {
        operation = "plus";
        calculate();
    }
    @FXML
    protected void Onminus(ActionEvent actionEvent) {
        operation = "minus";
        calculate();
    }
    @FXML
    protected void Onmultiply(ActionEvent actionEvent) {
        operation = "multiply";
        calculate();
    }
    @FXML
    protected void Ondivide(ActionEvent actionEvent) {
        operation = "divide";
        calculate();
    }
    @FXML
    protected void Onpercentage(ActionEvent actionEvent) {
        operation = "percentage";
        calculate();
    }
    private void calculate(){
        double cal = 0;
        System.out.println(operation);
        try{
            if(first_input.getText().isEmpty() || second_input.getText().isEmpty()){
                throw new IllegalArgumentException("All fields must be filled");
            }
            switch (operation){
                case "plus" : {
                    cal = Double.parseDouble(first_input.getText()) + Double.parseDouble(second_input.getText());
                    break;
                }
                case "minus": {
                    cal = Double.parseDouble(first_input.getText()) - Double.parseDouble(second_input.getText());
                    break;
                }
                case "multiply": {
                    cal = Double.parseDouble(first_input.getText()) * Double.parseDouble(second_input.getText());
                    break;
                }
                case "divide" : {
                    if(Double.parseDouble(second_input.getText()) == 0){
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    cal = Math.round((Double.parseDouble(first_input.getText()) / Double.parseDouble(second_input.getText())*100.0)/100.0);
                    break;
                }
                case "percentage" : {
                    cal = Double.parseDouble(first_input.getText()) % Double.parseDouble(second_input.getText());
                    break;
                }
            }
            number.setText(String.valueOf(cal));
        }
        catch (NumberFormatException e){
            showAlert("Invalid input","Please enter valid numbers");
        }
        catch(IllegalArgumentException | ArithmeticException e){
            showAlert("Error",e.getMessage());
        }


    }
    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}