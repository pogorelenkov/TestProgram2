package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Testing {
    Test test;
    ArrayList<Answer> data;

    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb3;

    @FXML
    private Label labelAn6;

    @FXML
    private RadioButton rb2;

    @FXML
    private Label labelAn5;

    @FXML
    private RadioButton rb5;

    @FXML
    private Label labelAn4;

    @FXML
    private Label labelRez4;

    @FXML
    private RadioButton rb4;

    @FXML
    private Label labelRez3;

    @FXML
    private Label labelAn3;

    @FXML
    private Label labelRez6;

    @FXML
    private Label labelAn2;

    @FXML
    private RadioButton rb6;

    @FXML
    private Label labelRez5;

    @FXML
    private Label labelAn1;

    @FXML
    private Label labelPercent;

    @FXML
    private TextArea textArea;

    @FXML
    private Label labelCount;

    @FXML
    private Button buttonNext;

    @FXML
    private Label labelRez2;

    @FXML
    private Label labelRez1;

    @FXML
    private Label labelTimer;

    @FXML
    private Label labCheck1;

    @FXML
    private Label labCheck2;

    @FXML
    private Label labCheck3;

    @FXML
    private Label labCheck4;

    @FXML
    private Label labCheck5;

    @FXML
    private Label labCheck6;

    Timeline timeline;
    final int FULLTIME = Main.test.getTime();
    int timeMin;
    int timeSec;
    int timeDuraction;

    public void initialize() throws IOException {
        test = Main.test;
        data = test.getData();
        Collections.shuffle(data);

        labelCount.setText((int) Main.currentTest + "/" + test.getCountOfQuestions());
        timeMin = FULLTIME;
        setTime();

        startCountdown();
        createNewTest();
    }

    void setTime() throws IOException {
        if (timeSec == 0) {
            if (timeMin != 0) {
                timeMin--;
                timeSec = 60;
            } else {

                endTest();
            }
        }

        if (timeMin < 10) {
            labelTimer.setText("0" + timeMin + ":");
            if (timeSec < 10) {
                labelTimer.setText("0" +timeMin + ":" + "0" + timeSec);
            } else {
                labelTimer.setText("0" + timeMin + ":" + timeSec);
            }
        } else {
            labelTimer.setText(timeMin + ":");
            if (timeSec < 10) {
                labelTimer.setText(timeMin + ":" + "0" + timeSec);
            } else {
                labelTimer.setText(timeMin + ":" + timeSec);
            }
        }


    }

    void startCountdown() throws IOException {
        if (timeline != null) {
            timeline.stop();
        }
        timeDuraction = FULLTIME;
        setTime();
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeSec--;
                try {
                    setTime();
                } catch (IOException e) {
                }
            }
        }));
        timeline.playFromStart();


    }

    @FXML
    void buttonNext_Event() throws IOException {
        Main.currentTest++;
        labelCount.setText((int) Main.currentTest + "/" + test.getCountOfQuestions());
        if (Main.currentTest > test.getCountOfQuestions()) {

        } else {

            if (Main.currentTest == test.getCountOfQuestions()) {
                checkTest();
                endTest();
            } else {
                checkTest();
                createNewTest();
            }
        }


    }

    void createNewTest() {

        rb1.setDisable(false);
        rb2.setDisable(false);
        rb3.setDisable(false);
        rb4.setDisable(false);
        rb5.setDisable(false);
        rb6.setDisable(false);

        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);

        labCheck1.setText("-");
        labCheck2.setText("-");
        labCheck3.setText("-");
        labCheck4.setText("-");
        labCheck5.setText("-");
        labCheck6.setText("-");

        labelAn1.setText("");
        labelAn2.setText("");
        labelAn3.setText("");
        labelAn4.setText("");
        labelAn5.setText("");
        labelAn6.setText("");

        labelRez1.setText("");
        labelRez2.setText("");
        labelRez3.setText("");
        labelRez4.setText("");
        labelRez5.setText("");
        labelRez6.setText("");

        Answer currentTest = data.get(0);
        int countOfAnswers = currentTest.getCountOfAnswers();
        ArrayList<String> prom = new ArrayList<String>();
        textArea.setText(currentTest.getQuestion());

        if (countOfAnswers == 2) {
            prom.add(currentTest.getAnswer1());
            prom.add(currentTest.getAnswer2());
            rb3.setDisable(true);
            rb4.setDisable(true);
            rb5.setDisable(true);
            rb6.setDisable(true);
            Collections.shuffle(prom);

            if (prom.get(0).contains("*_*")) {
                labelAn1.setText(prom.get(0).replace("*_*", ""));
                labCheck1.setText("+");
            } else {
                labelAn1.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn2.setText(prom.get(0).replace("*_*", ""));
                labCheck2.setText("+");
            } else {
                labelAn2.setText(prom.get(0));
            }
        }
        if (countOfAnswers == 3) {
            prom.add(currentTest.getAnswer1());
            prom.add(currentTest.getAnswer2());
            prom.add(currentTest.getAnswer3());
            rb4.setDisable(true);
            rb5.setDisable(true);
            rb6.setDisable(true);

            Collections.shuffle(prom);

            if (prom.get(0).contains("*_*")) {
                labelAn1.setText(prom.get(0).replace("*_*", ""));
                labCheck1.setText("+");
            } else {
                labelAn1.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn2.setText(prom.get(0).replace("*_*", ""));
                labCheck2.setText("+");
            } else {
                labelAn2.setText(prom.get(0));
            }
            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn3.setText(prom.get(0).replace("*_*", ""));
                labCheck3.setText("+");
            } else {
                labelAn3.setText(prom.get(0));
            }

        }
        if (countOfAnswers == 4) {
            prom.add(currentTest.getAnswer1());
            prom.add(currentTest.getAnswer2());
            prom.add(currentTest.getAnswer3());
            prom.add(currentTest.getAnswer4());
            rb5.setDisable(true);
            rb6.setDisable(true);
            Collections.shuffle(prom);

            if (prom.get(0).contains("*_*")) {
                labelAn1.setText(prom.get(0).replace("*_*", ""));
                labCheck1.setText("+");
            } else {
                labelAn1.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn2.setText(prom.get(0).replace("*_*", ""));
                labCheck2.setText("+");
            } else {
                labelAn2.setText(prom.get(0));
            }
            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn3.setText(prom.get(0).replace("*_*", ""));
                labCheck3.setText("+");
            } else {
                labelAn3.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn4.setText(prom.get(0).replace("*_*", ""));
                labCheck4.setText("+");
            } else {
                labelAn4.setText(prom.get(0));
            }

        }
        if (countOfAnswers == 5) {
            prom.add(currentTest.getAnswer1());
            prom.add(currentTest.getAnswer2());
            prom.add(currentTest.getAnswer3());
            prom.add(currentTest.getAnswer4());
            prom.add(currentTest.getAnswer5());
            rb6.setDisable(true);
            Collections.shuffle(prom);

            if (prom.get(0).contains("*_*")) {
                labelAn1.setText(prom.get(0).replace("*_*", ""));
                labCheck1.setText("+");
            } else {
                labelAn1.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn2.setText(prom.get(0).replace("*_*", ""));
                labCheck2.setText("+");
            } else {
                labelAn2.setText(prom.get(0));
            }
            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn3.setText(prom.get(0).replace("*_*", ""));
                labCheck3.setText("+");
            } else {
                labelAn3.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn4.setText(prom.get(0).replace("*_*", ""));
                labCheck4.setText("+");
            } else {
                labelAn4.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn5.setText(prom.get(0).replace("*_*", ""));
                labCheck5.setText("+");
            } else {
                labelAn5.setText(prom.get(0));
            }

        }
        if (countOfAnswers == 6) {
            prom.add(currentTest.getAnswer1());
            prom.add(currentTest.getAnswer2());
            prom.add(currentTest.getAnswer3());
            prom.add(currentTest.getAnswer4());
            prom.add(currentTest.getAnswer5());
            prom.add(currentTest.getAnswer6());
            Collections.shuffle(prom);

            if (prom.get(0).contains("*_*")) {
                labelAn1.setText(prom.get(0).replace("*_*", ""));
                labCheck1.setText("+");
            } else {
                labelAn1.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn2.setText(prom.get(0).replace("*_*", ""));
                labCheck2.setText("+");
            } else {
                labelAn2.setText(prom.get(0));
            }
            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn3.setText(prom.get(0).replace("*_*", ""));
                labCheck3.setText("+");
            } else {
                labelAn3.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn4.setText(prom.get(0).replace("*_*", ""));
                labCheck4.setText("+");
            } else {
                labelAn4.setText(prom.get(0));
            }

            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn5.setText(prom.get(0).replace("*_*", ""));
                labCheck5.setText("+");
            } else {
                labelAn5.setText(prom.get(0));
            }
            prom.remove(0);

            if (prom.get(0).contains("*_*")) {
                labelAn6.setText(prom.get(0).replace("*_*", ""));
                labCheck6.setText("+");
            } else {
                labelAn6.setText(prom.get(0));
            }

        }
        prom.clear();
        data.remove(0);


    }

    void checkTest() {
        String prom1;
        String prom2;
        String prom3;
        String prom4;
        String prom5;
        String prom6;

        if (rb1.isSelected()) {
            prom1 = "+";
        } else {
            prom1 = "-";
        }
        if (rb2.isSelected()) {
            prom2 = "+";
        } else {
            prom2 = "-";
        }
        if (rb3.isSelected()) {
            prom3 = "+";
        } else {
            prom3 = "-";
        }
        if (rb4.isSelected()) {
            prom4 = "+";
        } else {
            prom4 = "-";
        }
        if (rb5.isSelected()) {
            prom5 = "+";
        } else {
            prom5 = "-";
        }
        if (rb6.isSelected()) {
            prom6 = "+";
        } else {
            prom6 = "-";
        }


        if (prom1.equals(labCheck1.getText()) && prom2.equals(labCheck2.getText()) &&
                prom3.equals(labCheck3.getText()) && prom4.equals(labCheck4.getText())
                && prom5.equals(labCheck5.getText()) && prom6.equals(labCheck6.getText())) {

            Main.correctTest++;
        }
        labelPercent.setText(String.valueOf((int) ((Main.correctTest / Main.currentTest) * 100) + "%"));


    }

    void endTest() throws IOException {

        if (timeline != null) {
            timeline.stop();
        }
        timeline=null;
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(
                getClass().getResource("EndingTest.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.primaryStage);
        stage.setResizable(false);

        stage.show();

        File file = new File("src/resources/student Information");
        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file, true));
        bufferWriter.write(" Mark: "+(int)((Main.correctTest*12)/Main.test.getCountOfQuestions())+"\n");
        bufferWriter.close();

        Main.correctTest=0;
        Main.currentTest=0;

    }
}
