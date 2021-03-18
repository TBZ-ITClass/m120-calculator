package io.genetv.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BackgroundController {

    @FXML
    public static GridPane backgroundGrid;

    public BackgroundController(GridPane backgroundGrid) {
        this.backgroundGrid = backgroundGrid;
    }


    public void setColor(ActionEvent event) {
        System.out.println(backgroundGrid);
        String color = ((Button)event.getSource()).getText();
        backgroundGrid.setStyle("-fx-background-color: " + color + ";");
    }
}
