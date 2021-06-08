package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EndingTest {

    @FXML
    private Label labCountOfCorrect;

    @FXML
    private Label labMark;

    @FXML
    private ProgressIndicator progInd;

    @FXML
    private Button buttonOK;

    @FXML
    private Label labCountOfIncorrect;

    public void initialize() {
        progInd.setProgress(Main.correctTest / Main.test.getCountOfQuestions());
        labCountOfCorrect.setText(String.valueOf((int) Main.correctTest));
        labCountOfIncorrect.setText(String.valueOf((int) (Main.test.getCountOfQuestions() - Main.correctTest)));
        labMark.setText(String.valueOf((int) ((Main.correctTest * 12) / Main.test.getCountOfQuestions())));


    }

    @FXML
    void buttonOK_Event() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Main.primaryStage.setScene(new Scene(root, Main.primaryStage.getWidth() - 16, Main.primaryStage.getHeight() - 39));
        Stage stage = (Stage) buttonOK.getScene().getWindow();
        stage.close();
    }

}