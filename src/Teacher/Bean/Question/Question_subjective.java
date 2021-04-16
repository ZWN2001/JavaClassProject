package Teacher.Bean.Question;

public class Question_subjective  {
    int qid = 0;
    String stem;
    int kind = 2;
    int mark = 0;
    int difficulty=0;
    String myAnswer = " ";

    public Question_subjective(String stem, int mark,int difficulty,String myAnswer) {
        this.stem = stem;
        this.mark = mark;
        this.difficulty=difficulty;
        this.myAnswer=myAnswer;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    public int getMark() {
        return mark;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getStem() {
        return stem;
    }
    public String getQuestion() {
        return stem;
    }
    public int getQid() {
        return qid;
    }
    public int getKind() {
        return kind;
    }
}
