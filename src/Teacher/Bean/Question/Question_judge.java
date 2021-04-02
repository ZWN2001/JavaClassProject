package Teacher.Bean.Question;

public class Question_judge extends Question{


    String stem;
    int kind=1;
    int mark=0;
    int myJudge=2;

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
    String getStem() {
        return stem;
    }

    @Override
    String getQuestion() {
        return stem;
    }

}
