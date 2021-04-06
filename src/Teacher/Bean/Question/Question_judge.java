package Teacher.Bean.Question;

public class Question_judge extends Question {

    int qid = 0;
    String stem;
    int kind = 1;
    int mark = 0;

    int myJudge = 2;

    public Question_judge(String stem, int mark) {
        this.stem = stem;
        this.mark = mark;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public void setMyJudge(int myJudge) {
        this.myJudge = myJudge;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public int getMyJudge() {
        return myJudge;
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
