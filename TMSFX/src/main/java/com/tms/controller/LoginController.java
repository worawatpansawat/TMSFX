package com.tms.controller;

import com.tms.MainApplication;
import com.tms.core.MessageBox;

import com.tms.data.UserData;
import com.tms.models.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private Label lblVersion;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button cmdOk;

    @FXML
    private Button cmdCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitle.setText(MainApplication.appProductName);
        lblVersion.setText("Version: " + MainApplication.appVersion);
        txtUsername.clear();
        txtPassword.clear();
    }

    @FXML
    public void onQuit() {
        //Stage current = (Stage) anchorPaneLogin.getScene().getWindow();
        quit();
    }

    @FXML
    public static void quit() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Message");
        confirm.setHeaderText(null);
        confirm.setContentText("Do you want to exit.");
        confirm.initStyle(StageStyle.UTILITY);

        if (confirm.showAndWait().get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    @FXML
    public void login() {
        if (txtUsername.getText().length() == 0) {
            MessageBox.showMessage(Alert.AlertType.INFORMATION, "", "", "Username is require");
            txtUsername.requestFocus();
            return;
        }

        if (txtPassword.getText().length() == 0) {
            MessageBox.showMessage(Alert.AlertType.INFORMATION, "", "", "Password is require");
            txtPassword.requestFocus();
            return;
        }

        List<User> userLogIn = new UserData().requestLogOn(txtUsername.getText(), txtPassword.getText());
        if (!userLogIn.isEmpty()) {

            Stage mainScreen = new Stage();
            Parent root = null;

            try {
                root = FXMLLoader.load(getClass().getResource("/com/tms/mainscreen.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            Stage current = (Stage) txtUsername.getScene().getWindow();
            Scene scene = new Scene(root);

            mainScreen.setTitle(MainApplication.appProductName);
            mainScreen.setScene(scene);
            current.hide();

            mainScreen.setOnCloseRequest(actionOnCloseEvent -> {
                actionOnCloseEvent.consume();
                LoginController.quit();
            });


            mainScreen.setMinHeight(500);
            mainScreen.setMinWidth(850);
            mainScreen.getIcons().add(new Image(getClass().getResourceAsStream("/img/icons/application_side_boxes.png")));
            mainScreen.show();

        } else {
            MessageBox.showMessage(Alert.AlertType.WARNING, "", "", "Invalid Username or Password.");
            txtPassword.requestFocus();
        }

    }

}
