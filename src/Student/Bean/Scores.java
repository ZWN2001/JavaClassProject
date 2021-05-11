package Student.Bean;

import Teacher.Bean.Paper;

public class Scores {
    private String student;
    private Paper paper;
    private int objectiveScore;
    private int subjectiveScore;
    private int score;

    public Scores(String student, Paper paper, int objectiveScore, int subjectiveScore) {
        this.student = student;
        this.paper = paper;
        this.objectiveScore = objectiveScore;
        this.subjectiveScore = subjectiveScore;
        if (subjectiveScore>0){
            score=objectiveScore+subjectiveScore;
        }
        else score=objectiveScore;
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

    public int getObjectiveScore() {
        return objectiveScore;
    }

    public void setObjectiveScore(int objectiveScore) {
        this.objectiveScore = objectiveScore;
    }

    public int getSubjectiveScore() {
        return subjectiveScore;
    }

    public int getScore() {
        return score;
    }

    public void setSubjectiveScore(int subjectiveScore) {
        this.subjectiveScore = subjectiveScore;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
