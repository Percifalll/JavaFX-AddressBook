package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.impl.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private PersonService service;

    private Stage mainStage;
    private Parent fxmlEdit;
    private Parent fxmlAdd;
    private Stage editDialogStage;
    private Stage addDialogStage;
    private AddController addController;
    private EditController editController;

    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, Integer> columnId;

    @FXML
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnNumber;

    @FXML
    private ComboBox<String> searchChoiceBox;
    @FXML
    private TextField searchTextField;

    @FXML
    private Label recordsCount;

    public void initialize() {
        service = new PersonService();
        ObservableList<Person> observableList = service.getAll();
        personTable = new TableView<>();

        personTable.setItems(observableList);

        columnId.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<Person, String>("number"));

        personTable.getColumns().add(columnId);
        personTable.getColumns().add(columnName);
        personTable.getColumns().add(columnNumber);
        personTable.refresh();

        observableList.addListener((ListChangeListener<Person>) change ->
                recordsCount.setText("Count:" + service.getAll().size()));

        searchChoiceBox.getItems().addAll("Id", "Name", "Number");
        searchChoiceBox.setValue("Id");
        FXMLLoader fxmlLoader;

        try {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/demo/edit-view.fxml"));
            fxmlEdit = fxmlLoader.load();
            editController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/demo/add-view.fxml"));
            fxmlAdd = fxmlLoader.load();
            addController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        service.save(new Person("Name", "1234567890"));
        service.save(new Person("Name2", "1234567891"));
        service.save(new Person("Name3", "1234567892"));
    }

    public void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public void showAddWindow() {
        if (addDialogStage == null) {
            addDialogStage = new Stage();
            addDialogStage.setTitle("Add record");
            addDialogStage.setResizable(false);
            addDialogStage.setScene(new Scene(fxmlAdd));
            addDialogStage.initOwner(mainStage);
            addDialogStage.initModality(Modality.WINDOW_MODAL);
            addController.setService(service);
        }
        addDialogStage.showAndWait();
    }

    public void showEditWindow() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Edit record");
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initOwner(mainStage);
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editController.setService(service);
        }
        editDialogStage.showAndWait();
    }

    @FXML
    public void addButtonClick(MouseEvent event) {
        showAddWindow();
    }

    @FXML
    public void editButtonClick(MouseEvent event) {
        Person person = personTable.getSelectionModel().getSelectedItem();

        if (person == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Person not selected");
            alert.setContentText("To edit a person select it from table");

            alert.showAndWait();
        } else {
            editController.setPerson(person);
            showEditWindow();
        }
    }

    @FXML
    public void removeButtonClick(MouseEvent event) {
        Person[] selected = personTable.getSelectionModel().getSelectedItems().toArray(Person[]::new);

        for (Person person : selected) {
            service.remove(person);
        }
    }

    @FXML
    public void searchButtonClick(MouseEvent event) {

    }
}
