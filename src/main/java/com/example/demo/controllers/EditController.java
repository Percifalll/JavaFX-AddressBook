package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.Service;
import com.example.demo.utils.Regex;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EditController {
    private Person person;
    private Service service;

    @FXML
    private Button editButton;

    @FXML
    private Button editClearButton;

    @FXML
    private TextField editNamesField;

    @FXML
    private TextField editPhoneField;

    public void setService(Service service) {
        this.service = service;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @FXML
    void clearOnClick(MouseEvent event) {
        editNamesField.clear();
        editPhoneField.clear();
    }

    @FXML
    void editOnClick(MouseEvent event) {
        String name = editNamesField.getText();
        String number = editNamesField.getText();

        if (name.matches(Regex.NAME_REGEX) &&
                number.matches(Regex.NUMBER_REGEX)){
            person.setNameAndSurname(name);
            person.setNumber(number);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect input format");
            alert.setHeaderText("Name or number doesn't correspond the requirements");
            alert.setContentText("Name should start with big letter and number should consist of 10 digits");

            alert.showAndWait();
        }
    }

}
