package com.tms;

import com.tms.controller.LoginController;
import com.tms.core.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {

    public static final String appProductName = "Training Management System";
    public static final String appVersion = "1.0.1002321000";

    @Override
    public void start(Stage stage) throws IOException {
        //loadLogin(stage);
        loadMain(stage);
    }

    public static void main(String[] args) {
        DbConnection.connect();
        launch();
    }

    private void loadLogin(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loginscreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(MainApplication.appProductName);
        stage.setScene(scene);

        stage.setOnCloseRequest(actionOnCloseEvent -> {
            actionOnCloseEvent.consume();
            LoginController.quit();
        });

        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icons/login.png")));
        stage.setResizable(false);
        stage.show();
    }

    private void loadMain(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainscreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(MainApplication.appProductName);
        stage.setScene(scene);

        stage.setOnCloseRequest(actionOnCloseEvent -> {
            actionOnCloseEvent.consume();
            LoginController.quit();
        });

        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icons/overlays.png")));
        stage.setResizable(true);
        stage.setMinHeight(430);
        stage.setMinWidth(650);
        stage.show();

    }
}