package qGenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("qGenerator.fxml"));
        primaryStage.setTitle("Math Question Generator");
        primaryStage.setScene(new Scene(root, 509, 745));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("Welcome");
        launch(args);
    }
}
