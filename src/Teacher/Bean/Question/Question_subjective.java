package Teacher.Bean.Question;

public class Question_subjective extends Question{
    String stem;
    int kind=2;
    int mark=0;
    String myAnswer=" ";

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
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
