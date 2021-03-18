package io.genetv.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BackgroundController {

    @FXML
    GridPane backgroundGrid;


    public void setColor(ActionEvent event) {

        String color = ((Button)event.getSource()).getText();
        backgroundGrid.setStyle("-fx-background-color: " + color + ";");

    }
}
