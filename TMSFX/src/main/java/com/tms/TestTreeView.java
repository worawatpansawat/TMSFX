package com.tms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TestTreeView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        createTree(primaryStage);
    }


    public static void main(String[] args) {
        launch();
    }

    private void createTree(Stage stage) {
        // create some sample data.
        TreeMap<String, List<String>> data = new TreeMap<>();

        data.put("Sales & Distribution", Arrays.asList("Quotations", "Sales Order", "Delivery"));


        data.put("Inventory", Arrays.asList("Plants", "Warehouse"));
        data.put("Plants", Arrays.asList("Create Plant", "Change Plant", "Delete Plant"));
        data.put("Warehouse", Arrays.asList("Create Warehouse", "Change Warehouse", "Delete Warehouse"));
        data.put("Delete Plant", Arrays.asList("by Item", "Bulk Delete"));
        data.put("Bulk Delete", Arrays.asList("by Item", "Bulk All"));

        data.put("Accounting", Arrays.asList("Definition"));

        data.put("Setup", Arrays.asList("Accounts"));

        String[] rootKeys = {
                "Sales & Distribution",
                "Inventory",
                "Accounting",
                "Setup"
        };

        // create the tree from the data.
        TreeView<String> tree = createTreeView(
                data,
                rootKeys
        );

        // display the tree.
        Scene scene = new Scene(tree);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Create a TreeView of a set of data
     * given the data and identified roots within the data.
     */
    private TreeView<String> createTreeView(
            TreeMap<String, List<String>> data,
            String[] rootKeys
    ) {
        TreeItem<String> root = new TreeItem<>();
        Arrays.stream(rootKeys).forEach(
                rootKey ->
                        root.getChildren().add(
                                createTreeItem(data, rootKey)
                        )
        );

        TreeView<String> tree = new TreeView<>();
        tree.setRoot(root);
        tree.setShowRoot(false);

        return tree;
    }

    /**
     * Create a TreeItem for a TreeView from a set of data
     * given the data and an identified root within the data.
     */
    private TreeItem<String> createTreeItem(
            TreeMap<String, List<String>> data,
            String rootKey
    ) {
        TreeItem<String> item = new TreeItem<>();
        item.setValue(rootKey);
        item.setExpanded(true);

        List<String> childData = data.get(rootKey);
        if (childData != null) {
            childData.stream()
                    .sorted()
                    .map(
                            child -> createTreeItem(data, child)
                    )
                    .collect(
                            Collectors.toCollection(item::getChildren)
                    );
        }

        return item;
    }

}
