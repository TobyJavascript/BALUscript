package org.balu.ui;

import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import org.balu.ui.BALUwindowController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BALUwindow extends Application {

    BALUwindowController controller = new BALUwindowController();

    /**
     * Start method that creates gui components and sets it up.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a BorderPane
        BorderPane root = new BorderPane();

        VBox topBox = createTopPane();
        HBox bottomBox = createBottomPane();
        HBox centerBox = createCenterPane();
        root.setTop(topBox);
        root.setBottom(bottomBox);
        root.setCenter(centerBox);
        bottomBox.prefWidthProperty().bind(root.widthProperty());

        Scene scene = new Scene(root, 999, 700);
        scene.getStylesheets().add("./CSS/style.css");

        primaryStage.setTitle("BALUscript editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Method for exiting the application.
     */
    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * Starts the application by calling the static method launch().
     *
     * @param args not used in this applicatiton
     */
    public static void appMain(String[] args) {
        launch();
    }

    public VBox createTopPane () {
        VBox newBox = new VBox();

        // Distributes objects to border areas
        newBox.getChildren().addAll(createRibbonBar(),createToolBar());

        newBox.getStyleClass().add("topBox");

        return newBox;
    }

    public HBox createToolBar() {
        HBox newBox = new HBox();

        // Creates buttons
        Button button1 = new Button("Test1");
        button1.getStyleClass().add("button");
        Button button2 = new Button("Test2");
        button2.getStyleClass().add("button");

        // Distributes objects to border areas
        newBox.getChildren().addAll(button1, button2);

        return newBox;
    }

    public HBox createRibbonBar() {
        HBox newBox = new HBox();

        MenuBar menuBar  = new MenuBar();
        Menu    menuFile = new Menu("File");
        Menu    menuEdit = new Menu("Edit");
        Menu    menuView = new Menu("View");
        Menu    menuHelp = new Menu("Help");

        menuBar.getMenus().addAll(menuFile,menuEdit,menuView,menuHelp);

        // Create MenuItems
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open...");
        MenuItem exitItem = new MenuItem("Exit");

        // Add MenuItems to the File Menu
        menuFile.getItems().addAll(newItem, openItem, new SeparatorMenuItem(), exitItem);

        newBox.getChildren().addAll(menuBar);

        // Action for New item
        newItem.setOnAction(e -> {
            System.out.println("Creating new file...");
            // Insert your logic here
        });

        // Action for Open item
        openItem.setOnAction(e -> {
            System.out.println("Opening file...");
            // Insert your logic here
        });

        // Action for Exit item
        exitItem.setOnAction(e -> {
            System.exit(0); // Closes the application
        });

        return newBox;
    }

    public HBox createBottomPane () {
        HBox newBox = new HBox();

        VBox buttonBox = new VBox();
        Button button1 = new Button("Button1");
        button1.getStyleClass().add("button");
        Button button2 = new Button("Button2");
        button2.getStyleClass().add("button");
        buttonBox.getChildren().addAll(button1,button2);

        // Create a TextArea object
        TextArea textArea = new TextArea();

        // Optional: Configure the TextArea
        textArea.setPromptText("Enter your text here...");
        textArea.getStyleClass().add("terminalTextArea");


        // Distributes objects to border areas
        newBox.getChildren().addAll(buttonBox,textArea);
        HBox.setHgrow(textArea, Priority.ALWAYS);
        newBox.getStyleClass().add("bottomBox");

        return newBox;
    }

    private HBox createCenterPane() {
        HBox newBox = new HBox();

        TextArea textArea = new TextArea();

        newBox.getChildren().add(textArea);
        HBox.setHgrow(textArea, Priority.ALWAYS);
        newBox.getStyleClass().add("centerBox");

        return newBox;
    }




}
