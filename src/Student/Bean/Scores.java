package Student.Bean;

import Teacher.Bean.Paper;

public class Scores {
    private String student;
    private Paper paper;
    private int score;

    public Scores(String student, Paper paper, int score) {
        this.student = student;
        this.paper = paper;
        this.score = score;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
