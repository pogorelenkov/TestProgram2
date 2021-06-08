package sample;

import java.io.Serializable;

public class Answer implements Serializable {

    private String question;
    private int countOfAnswers;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;

    Answer(int countOfAnswers, String question, String answer1, String answer2) {
        this.question = question;
        this.countOfAnswers = countOfAnswers;
        this.answer1 = answer1;
        this.answer2 = answer2;

    }

    Answer(int countOfAnswers, String question, String answer1, String answer2, String answer3) {
        this.question = question;
        this.countOfAnswers = countOfAnswers;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;

    }

    Answer(int countOfAnswers, String question, String answer1, String answer2, String answer3,
           String answer4) {
        this.question = question;
        this.countOfAnswers = countOfAnswers;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    Answer(int countOfAnswers, String question, String answer1, String answer2, String answer3,
           String answer4, String answer5) {
        this.question = question;
        this.countOfAnswers = countOfAnswers;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;

    }

    Answer(int countOfAnswers, String question, String answer1, String answer2, String answer3,
           String answer4, String answer5, String answer6) {
        this.question = question;
        this.countOfAnswers = countOfAnswers;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;

    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public String getQuestion() {
        return question;
    }

    public int getCountOfAnswers() {
        return countOfAnswers;
    }


}