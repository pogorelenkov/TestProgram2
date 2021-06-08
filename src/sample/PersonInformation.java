package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

public class PersonInformation {

    @FXML
    private TextField textFieldName;

    @FXML
    private Button buttonConfirm;

    @FXML
    private TextField textFieldClass;

    @FXML
    private TextField textFieldSername;

    @FXML
    void buttonConfirm_Event(ActionEvent event) throws IOException, URISyntaxException {
        if (!textFieldName.getText().isEmpty() && !textFieldClass.getText().isEmpty() &&
                !textFieldSername.getText().isEmpty()) {

            File file = new File("src/resources/student Information");
            System.out.println(file.getCanonicalPath());
            System.out.println(file.getPath());

            try {
                BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file, true));
                bufferWriter.write("Date: " + new Date().toString() + " Name: " + textFieldName.getText() +
                        " Sername: " + textFieldSername.getText() + " Class: " + textFieldClass.getText() +
                        " Test: " + Main.file);
                bufferWriter.close();

                Parent root = FXMLLoader.load(getClass().getResource("Testing.fxml"));
                Main.primaryStage.setScene(new Scene(root, Main.primaryStage.getWidth()-16, Main.primaryStage.getHeight()-39));

                Stage stage = (Stage)textFieldClass.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
