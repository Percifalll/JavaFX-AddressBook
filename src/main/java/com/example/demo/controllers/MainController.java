package com.example.demo.controllers;

import com.example.demo.models.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage mainStage;
    private Parent fxmlEdit;
    private Parent fxmlAdd;
    private Stage editDialogStage;
    private Stage addDialogStage;
    private AddController addController;
    private EditController editController;

    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, Number> columnId;

    @FXML
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnNumber;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label recordsCount;

    public void initialize() {
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

        columnId.setCellValueFactory(features -> features.getValue().idProperty());
        columnName.setCellValueFactory(features -> features.getValue().nameProperty());
        columnNumber.setCellValueFactory(features -> features.getValue().numberProperty());
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
        }
        editDialogStage.showAndWait();
    }

    @FXML
    public void addButtonClick(MouseEvent event) {
        showAddWindow();
    }

    @FXML
    public void editButtonClick(MouseEvent event) {
        showEditWindow();
    }

    @FXML
    public void removeButtonClick(MouseEvent event) {
    }

    @FXML
    public void searchButtonClick(MouseEvent event) {
    }

    @FXML
    void resetButtonClick(MouseEvent event) {
    }
}
