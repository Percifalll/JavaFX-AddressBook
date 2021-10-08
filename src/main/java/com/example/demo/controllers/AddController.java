package com.example.demo.controllers;

import com.example.demo.services.impl.PersonService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddController {

    private PersonService service;

    @FXML
    private Button addButton;

    @FXML
    private Button addClearButton;

    @FXML
    private TextField addNamesField;

    @FXML
    private TextField addPhoneField;

    @FXML
    void addonClick(MouseEvent event) {

    }

    @FXML
    void clearOnClick(MouseEvent event) {

    }

}
