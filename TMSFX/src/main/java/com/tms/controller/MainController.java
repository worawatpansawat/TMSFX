package com.tms.controller;

import com.tms.MainApplication;
import com.tms.core.MessageBox;
import com.tms.models.SystemMenu;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainController {
    @FXML
    private Label lblTitle;

    @FXML
    private TreeView<SystemMenu> treeNavigation;

    @FXML
    protected void initialize() {

        //Stage current = (Stage) lblTitle.getScene().getWindow();
        lblTitle.setText(MainApplication.appProductName);
        //createMenu();
        createMenuTest();
    }

    protected void createMenuTest() {
        List<SystemMenu> menu = new ArrayList<>();
        menu.add(new SystemMenu("Department", "Master"));
        menu.add(new SystemMenu("Create", "Department"));
        menu.add(new SystemMenu("Change", "Department"));
        menu.add(new SystemMenu("Delete", "Department"));
        menu.add(new SystemMenu("New Transaction", "Transaction"));
        menu.add(new SystemMenu("Create Report", "", "Create_Report_01", "Tag (Create Report)"));


        Node rootIcon = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icons/home.png"))));
        Image parentIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icons/folder_database.png")));
        Image itemIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icons/page.png")));


        TreeItem<SystemMenu> rootNode = new TreeItem<>(new SystemMenu("My Company Co., Ltd."), rootIcon);
        treeNavigation.setRoot(rootNode);


        for (SystemMenu m : menu) {

            TreeItem<SystemMenu> newItem = new TreeItem<>(
                    new SystemMenu(m.getName(),
                            m.getParentName(),
                            m.getKey(),
                            m.getTag())
                    , new ImageView(itemIcon));


            if (m.getParentName().contentEquals("")) {
                rootNode.getChildren().add(newItem);
            } else {

                boolean found = false;



                for (TreeItem<SystemMenu> searchNode : rootNode.getChildren()) {

                    System.out.println(rootNode.getChildren().size());
                    System.out.println(searchNode.getValue());
                    System.out.println(m.getParentName());

                    if (searchNode.getValue().getName().contentEquals(m.getParentName())) {
                        found = true;
                        searchNode.setGraphic(new ImageView(parentIcon));
                        searchNode.getChildren().add(newItem);
                        break;
                    }
                }

                if (!found) {
                    TreeItem<SystemMenu> parentItem = new TreeItem<>(
                            new SystemMenu(m.getParentName(),
                                    m.getParentName(),
                                    m.getKey(),
                                    m.getTag())
                            , new ImageView(parentIcon));

                    parentItem.getChildren().add(newItem);
                    rootNode.getChildren().add(parentItem);
                }
            }

        }

        rootNode.setExpanded(true);
        treeNavigation.setRoot(rootNode);
        treeNavigation.setEditable(false);

        treeNavigation.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                TreeItem<SystemMenu> selectedItem = treeNavigation.getSelectionModel().getSelectedItem();
                try {
                    if (selectedItem.isLeaf()) {
                        String sKey = selectedItem.valueProperty().get().getKey();
                        MessageBox.showMessage(
                                Alert.AlertType.INFORMATION,
                                "",
                                "",
                                "Item key: " + sKey);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

    }

//    protected void createMenu() {
//
//        List<SystemMenu> menu = new ArrayList<>();
//        menu.add(new SystemMenu("Ethan Williams", "Sales Department"));
//        menu.add(new SystemMenu("Emma Jones", "Sales Department","/com/tms/DefineDepartment.fxml") );
//        menu.add(new SystemMenu("Michael Brown", "Sales Department"));
//        menu.add(new SystemMenu("Anna Black", "Sales Department"));
//        menu.add(new SystemMenu("Rodger York", "Sales Department"));
//        menu.add(new SystemMenu("Susan Collins", "Sales Department"));
//        menu.add(new SystemMenu("Mike Graham", "IT Support", "/com/tms/DefineXXX.fxml"));
//        menu.add(new SystemMenu("Judy Mayer", "IT Support"));
//        menu.add(new SystemMenu("Gregory Smith", "IT Support"));
//        menu.add(new SystemMenu("Jacob Smith", "Accounts Department"));
//        menu.add(new SystemMenu("Isabella Johnson", "Accounts Department"));
//        menu.add(new SystemMenu("Create", "Master"));
//
//
//        Node rootIcon = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icons/home.png"))));
//        Image parentIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icons/folder_database.png")));
//        Image itemIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icons/page.png")));
//
//        TreeItem<String> rootNode = new TreeItem<>("MyCompany Co., Ltd.", rootIcon);
//        rootNode.setExpanded(true);
//
//        for (SystemMenu m : menu) {
//
//            TreeItem<String> item = new TreeItem<>(m.getName(), new ImageView(itemIcon));
//
//            boolean found = false;
//            for (TreeItem<String> searchNode : rootNode.getChildren()) {
//                if (searchNode.getValue().contentEquals(m.getParentName())) {
//                    searchNode.getChildren().add(item);
//                    found = true;
//                    break;
//                }
//            }
//
//            //Create Parent
//            if (!found) {
//                TreeItem<String> parentNode = new TreeItem<>(m.getParentName(), new ImageView(parentIcon));
//                rootNode.getChildren().add(parentNode);
//                parentNode.getChildren().add(item);
//            }
//        }
//
//        treeNavigation.setRoot(rootNode);
//        treeNavigation.setEditable(false);
//
//        treeNavigation.setOnMouseClicked(event -> {
//            if (event.getClickCount() == 2) {
//                TreeItem<String> item = treeNavigation.getSelectionModel().getSelectedItem();
//
//                try {
//                    if (item.isLeaf()) {
//                        MessageBox.showMessage(
//                                Alert.AlertType.INFORMATION,
//                                "",
//                                "",
//                                "Item value: " + item.getValue());
//                    }
//                } catch (Exception e) {
//                    System.out.println(e.toString());
//                }
//            }
//        });
//
//    }

}