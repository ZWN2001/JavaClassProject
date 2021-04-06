package Teacher.Bean.Question;

public class Question_subjective extends Question {
    int qid = 0;
    String stem;
    int kind = 2;
    int mark = 0;

    String myAnswer = " ";

    public Question_subjective(String stem, int mark) {
        this.stem = stem;
        this.mark = mark;
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

    @Override
    public String getStem() {
        return stem;
    }

    @Override
    public String getQuestion() {
        return stem;
    }

    @Override
    public int getQid() {
        return qid;
    }

    @Override
    public int getKind() {
        return kind;
    }
}
