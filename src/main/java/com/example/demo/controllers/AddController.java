package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.Service;
import com.example.demo.utils.Regex;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddController {

    Service service;

    @FXML
    private Button addButton;

    @FXML
    private Button addClearButton;

    @FXML
    private TextField addNamesField;

    @FXML
    private TextField addNumberField;

    @FXML
    void addOnClick(MouseEvent event) {
        String name = addNamesField.getText();
        String number = addNumberField.getText();
        Person newPerson;

        if (name.matches(Regex.NAME_REGEX) &&
                number.matches(Regex.NUMBER_REGEX)){
            newPerson = new Person(name, number);
            service.save(newPerson);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect input format");
            alert.setHeaderText("Name or number doesn't correspond the requirements");
            alert.setContentText("Name should start with big letter and number should consist of 10 digits");

            alert.showAndWait();
        }
    }

    @FXML
    void clearOnClick(MouseEvent event) {
        addNamesField.clear();
        addNumberField.clear();
    }

    public void setService(Service service) {
        this.service = service;
    }

}
