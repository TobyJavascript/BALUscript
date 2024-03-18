package org.balu.ui;

import org.balu.ui.BALUwindowController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

        root.setTop(createTopPane());

        Scene scene = new Scene(root, 999, 700);

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

        return newBox;
    }

    public HBox createToolBar() {
        HBox newBox = new HBox();

        // Creates buttons
        Button button1 = new Button("Test1");
        Button button2 = new Button("Test2");

        // Distributes objects to border areas
        newBox.getChildren().addAll(button1, button2);

        return newBox;
    }

    public HBox createRibbonBar() {
        HBox newBox = new HBox();

        // Creates combo boxes
        ComboBox<String> dropdown1 = new ComboBox<>();
        dropdown1.setPromptText("File");
        ComboBox<String> dropdown2 = new ComboBox<>();
        dropdown2.setPromptText("Edit");

        // Distributes objects to border areas
        newBox.getChildren().addAll(dropdown1,dropdown2);

        return newBox;
    }

    public HBox createBottomPane () {
        HBox newBox = new HBox();

        // Distributes objects to border areas
        newBox.getChildren().addAll();

        return newBox;
    }


}
