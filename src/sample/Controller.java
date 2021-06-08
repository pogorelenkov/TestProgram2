package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Controller {

    @FXML
    private Button buttonCreateTest;

    @FXML
    private Button buttonStart;

    @FXML
    private Button buttonSearchFile;

    @FXML
    private TextField textField;

    public void initialize() {

    }

    @FXML
    void buttonSearchFile_Event() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecting test");
        File file = fileChooser.showOpenDialog(Main.primaryStage);
        if (file != null) {
            if (file.getName().contains(".txt")) {
                openFile(file);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect test!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void buttonCreateTest_Event() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("createMenu.fxml"));
        Main.primaryStage.setScene(new Scene(root, Main.primaryStage.getWidth()-16,Main.primaryStage.getHeight()-39));
    }

    @FXML
    void buttonStart_Event(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                getClass().getResource("personInformation.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Requesting information");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node)event.getSource()).getScene().getWindow() );
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void buttonStart_Entered() {
        buttonStart.setStyle("-fx-background-color: #30d330ff; -fx-background-radius: 46;" +
                "-fx-border-color: #669966ff;-fx-border-radius:40;-fx-border-width:10");
    }

    @FXML
    void buttonStart_Exited() {
        buttonStart.setStyle("-fx-background-color: #aac68cff; -fx-background-radius: 46;" +
                "-fx-border-color: #669966ff;-fx-border-radius:40;-fx-border-width:10");
    }

    private void openFile(File file) {
        try {
            textField.setText(file.getName());
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Main.test = (Test) ois.readObject();
            ois.close();
            Main.file =  file.getName().replace(".txt","");
            buttonStart.setDisable(false);



        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect test!");
            alert.showAndWait();
        }
    }

}
