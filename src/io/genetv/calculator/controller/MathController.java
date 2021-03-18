package io.genetv.calculator.controller;

import io.genetv.calculator.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.IOException;

public class MathController {


    public void openBackgroundSettings(ActionEvent actionEvent) throws IOException {
        System.out.println("Background color changer");

        Stage newWindow = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("settingsLayout.fxml"));


        GridPane subPane = (GridPane) fxmlLoader.load();
        Scene subScene = new Scene(subPane, 350, 175);

        newWindow.initModality(Modality.APPLICATION_MODAL);

        newWindow.setScene(subScene);
        newWindow.setTitle("Background Color");
        newWindow.setResizable(true);
        newWindow.show();

    }


    @FXML
    private TextField calcDisplay;


    public void handleInput(ActionEvent event) {

        String key = ((Button)event.getSource()).getText();
        String input = calcDisplay.getText();

        if(input.equals("Syntax error!")) {
            calcDisplay.setText("");
            return;
        }

        switch (key) {
            case "C":
                calcDisplay.setText("");
                break;

            case "√":
            case "+/-":
                break;

            case "=":
                try {
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByName("JavaScript");
                    calcDisplay.setText(engine.eval(input).toString());
                } catch (Exception ex) {
                    calcDisplay.setText("Syntax error!");
                }
                break;

            default:
                calcDisplay.setText(input + ((Button)event.getSource()).getText());
                break;
        }
    }
}
