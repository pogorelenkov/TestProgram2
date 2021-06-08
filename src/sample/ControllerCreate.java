package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sample.Main.primaryStage;

public class ControllerCreate {
    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonCreate;

    @FXML
    private Button buttonCheck;

    @FXML
    private Button buttonInfo;

    @FXML
    private TextArea textArea;

    @FXML
    void buttonInfo_Event() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Info.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Requesting information");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(buttonCancel.getScene().getWindow() );
        stage.show();

    }

    Test test = new Test();
    boolean allRight=true;
    @FXML
    void buttonCheck_Event() {
        try {
            String[] data = textArea.getText().split("\n");
            if (Integer.valueOf(data[0]) > 1 && Integer.valueOf(data[1]) > 0) {
                test.setCountOfQuestions(Integer.valueOf(data[0]));
                test.setTime(Integer.valueOf(data[1]));
                ArrayList<Answer> promArr = new ArrayList<Answer>();
                int index = 2;
                for (int i = 0; i < test.getCountOfQuestions(); i++) {
                    if (Integer.valueOf(data[index]) == 2) {
                        promArr.add(new Answer(Integer.valueOf(data[index]),
                                data[index + 1], data[index + 2], data[index + 3]));
                        index = index + 4;
                        test.setData(promArr);
                    } else {
                        if (Integer.valueOf(data[index]) == 3) {
                            promArr.add(new Answer(Integer.valueOf(data[index]),
                                    data[index + 1], data[index + 2], data[index + 3],
                                    data[index + 4]));
                            index = index + 5;
                            test.setData(promArr);
                        } else {
                            if (Integer.valueOf(data[index]) == 4) {
                                promArr.add(new Answer(Integer.valueOf(data[index]),
                                        data[index + 1], data[index + 2], data[index + 3],
                                        data[index + 4], data[index + 5]));
                                index = index + 6;
                                test.setData(promArr);
                            } else {
                                if (Integer.valueOf(data[index]) == 5) {
                                    promArr.add(new Answer(Integer.valueOf(data[index]),
                                            data[index + 1], data[index + 2], data[index + 3],
                                            data[index + 4], data[index + 5], data[index + 6]));
                                    index = index + 7;
                                    test.setData(promArr);
                                } else {
                                    if (Integer.valueOf(data[index]) == 6) {
                                        promArr.add(new Answer(Integer.valueOf(data[index]),
                                                data[index + 1], data[index + 2], data[index + 3],
                                                data[index + 4], data[index + 5], data[index + 6],
                                                data[index + 7]));
                                        index = index + 8;
                                        test.setData(promArr);
                                    } else {
                                        createExceprion();
                                        break;

                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                createExceprion();
                //throw new Exception();
            }

        } catch (Exception e) {
            createExceprion();

        }
        if(allRight){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Correct test!");
            alert.showAndWait();

        }else{
            allRight=true;
        }

    }

    @FXML
    void buttonCreate_Event() {
        try {
            String[] data = textArea.getText().split("\n");
            if (Integer.valueOf(data[0]) > 1 && Integer.valueOf(data[1]) > 0) {
                test.setCountOfQuestions(Integer.valueOf(data[0]));
                test.setTime(Integer.valueOf(data[1]));
                ArrayList<Answer> promArr = new ArrayList<Answer>();
                int index = 2;
                for (int i = 0; i < test.getCountOfQuestions(); i++) {
                    if (Integer.valueOf(data[index]) == 2) {
                        promArr.add(new Answer(Integer.valueOf(data[index]),
                                data[index + 1], data[index + 2], data[index + 3]));
                        index = index + 4;
                        test.setData(promArr);
                    } else {
                        if (Integer.valueOf(data[index]) == 3) {
                            promArr.add(new Answer(Integer.valueOf(data[index]),
                                    data[index + 1], data[index + 2], data[index + 3],
                                    data[index + 4]));
                            index = index + 5;
                            test.setData(promArr);
                        } else {
                            if (Integer.valueOf(data[index]) == 4) {
                                promArr.add(new Answer(Integer.valueOf(data[index]),
                                        data[index + 1], data[index + 2], data[index + 3],
                                        data[index + 4], data[index + 5]));
                                index = index + 6;
                                test.setData(promArr);
                            } else {
                                if (Integer.valueOf(data[index]) == 5) {
                                    promArr.add(new Answer(Integer.valueOf(data[index]),
                                            data[index + 1], data[index + 2], data[index + 3],
                                            data[index + 4], data[index + 5], data[index + 6]));
                                    index = index + 7;
                                    test.setData(promArr);
                                } else {
                                    if (Integer.valueOf(data[index]) == 6) {
                                        promArr.add(new Answer(Integer.valueOf(data[index]),
                                                data[index + 1], data[index + 2], data[index + 3],
                                                data[index + 4], data[index + 5], data[index + 6],
                                                data[index + 7]));
                                        index = index + 8;
                                        test.setData(promArr);
                                    } else {
                                        createExceprion();
                                        break;

                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                createExceprion();
            }

        } catch (Exception e) {
            createExceprion();
        }
        if (allRight) {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(primaryStage);
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(test);
                oos.flush();
                oos.close();
                Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                Main.primaryStage.setScene(new Scene(root, Main.primaryStage.getWidth()-16,Main.primaryStage.getHeight()-39));
            } catch (Exception ex) {

            }


        } else {
            allRight = true;
        }

    }
    @FXML
    private void buttonCancel_Event() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Main.primaryStage.setScene(new Scene(root, Main.primaryStage.getWidth()-16,Main.primaryStage.getHeight()-39));
    }
    void createExceprion(){
        textArea.setText("");
        allRight=false;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error ");
        alert.setHeaderText(null);
        alert.setContentText("Ooops, there was an error!");
        alert.showAndWait();
    }



}