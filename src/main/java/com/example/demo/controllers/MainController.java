package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.impl.PersonService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;

public class MainController {

    private PersonService service;

    private ObservableList<Person> observableList;

    @FXML
    private ComboBox<String> searchChoiceBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnNumber;

    @FXML
    private Label recordsCount;


    public void initialize() {
        service = new PersonService();
        observableList = FXCollections.observableArrayList(service.getAll());



        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("Name & Surname"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<Person, String>("Number"));

        observableList.addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                recordsCount.setText(String.valueOf(service.getAll().size()));
            }
        });

        searchChoiceBox.getItems().addAll("Id", "Name", "Number");
        searchChoiceBox.setValue("Id");
    }

    @FXML
    void addButtonClick(MouseEvent event) {

    }

    @FXML
    void editButtonClick(MouseEvent event) {

    }

    @FXML
    void removeButtonClick(MouseEvent event) {

    }

    @FXML
    void searchButtonClick(MouseEvent event) {

    }
}
