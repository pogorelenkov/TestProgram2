package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Test implements Serializable {

    private int countOfQuestions;
    private int time;
    private ArrayList<Answer> data;

    Test() {

    }

    Test(int countOfQuestions, int time, ArrayList<Answer> data) {
        this.countOfQuestions = countOfQuestions;
        this.time = time;
        this.data = data;

    }

    void setCountOfQuestions(int value) {
        countOfQuestions = value;
    }

    void setTime(int value) {
        time = value;
    }
    void setData(ArrayList<Answer> data){
        this.data=data;
    }

    public ArrayList<Answer> getData() {
        return data;
    }

    public int getCountOfQuestions() {
        return countOfQuestions;
    }

    public int getTime() {
        return time;
    }
}