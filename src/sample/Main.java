package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
   static Stage primaryStage;
   static Test test;
   static String file;
   static double currentTest=0;
   static double correctTest=0;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
      primaryStage.setScene(new Scene(root, 1000,700));
        primaryStage.setMinHeight(738);
        primaryStage.setMinWidth(600);
        primaryStage.setTitle("Testing Program");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
