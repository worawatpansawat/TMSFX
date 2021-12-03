package com.tms.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashscreenController implements Initializable {

    @FXML
    private ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing...");

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), image);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loginScreen = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/com/tms/loginscreen.fxml"));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

                Stage current = (Stage) image.getScene().getWindow();
                Scene scene = new Scene(root);

                loginScreen.setTitle("LogOn to HMS");
                loginScreen.setScene(scene);
                //loginScreen.initStyle(StageStyle.DECORATED);
                current.hide();

                loginScreen.setOnCloseRequest(actionOnCloseEvent -> {
                    actionOnCloseEvent.consume();
                    LoginController.quit();
                });

                loginScreen.show();
            }
        });

        fadeTransition.play();

    }
}
