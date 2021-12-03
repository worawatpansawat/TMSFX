package com.tms.core;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.stage.StageStyle;

public class MessageBox {

    public static void showMessage(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        if (title.length() == 0) {
            title = "Message";
        }
        alert.setTitle(title);

        if (headerText.length() > 0) {
            alert.setHeaderText(headerText);
        } else {
            alert.setHeaderText(null);
        }

        if (contentText.length() > 0) {
            alert.setContentText(contentText);
        } else {
            alert.setContentText(null);
        }
        alert.initStyle(StageStyle.UTILITY);
        alert.show();

    }
}
