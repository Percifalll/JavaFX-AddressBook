package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.Service;
import com.example.demo.utils.Regex;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        editPhoneField.setText(person.getNumber());
        editNamesField.setText(person.getName());
    }

    @FXML
    void clearOnClick(MouseEvent event) {
        editNamesField.clear();
        editPhoneField.clear();
    }

    @FXML
    void editOnClick(MouseEvent event) {
        String name = editNamesField.getText();
        String number = editPhoneField.getText();

        if (name.matches(Regex.NAME_REGEX) &&
                number.matches(Regex.NUMBER_REGEX)){
            person.setName(name);
            person.setNumber(number);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect input format");
            alert.setHeaderText("Name or number doesn't correspond the requirements");
            alert.setContentText("Name should start with big letter and number should consist of 10 digits");

            alert.showAndWait();
        }
    }

}
