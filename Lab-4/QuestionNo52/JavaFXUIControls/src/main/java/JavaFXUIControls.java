package org.example.javafxuicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class JavaFXUIControls extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI controls
        Label label = new Label("Enter your name:");
        TextField textField = new TextField();
        Button button = new Button("Submit");

        RadioButton radioButton1 = new RadioButton("Option 1");
        RadioButton radioButton2 = new RadioButton("Option 2");
        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);

        CheckBox checkBox1 = new CheckBox("CheckBox 1");
        CheckBox checkBox2 = new CheckBox("CheckBox 2");

        Hyperlink hyperlink = new Hyperlink("Visit Website");
        hyperlink.setOnAction(e -> {
            System.out.println("Hyperlink clicked!");
        });

        Tooltip tooltip = new Tooltip("Enter your full name here.");
        textField.setTooltip(tooltip);

        Menu menu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        menu.getItems().addAll(openItem, saveItem);
        MenuBar menuBar = new MenuBar(menu);

        FileChooser fileChooser = new FileChooser();
        button.setOnAction(e -> {
            fileChooser.setTitle("Open File");
            fileChooser.showOpenDialog(primaryStage);
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                menuBar, label, textField, button,
                radioButton1, radioButton2,
                checkBox1, checkBox2, hyperlink
        );

        // Scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("JavaFX UI Controls Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
