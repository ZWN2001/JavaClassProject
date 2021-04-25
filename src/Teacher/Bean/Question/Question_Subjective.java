package Teacher.Bean.Question;

public class Question_Subjective extends Question{
    int qid = 0;
    int kind = 2;
    String stem;
    int mark = 0;
    int difficulty=0;
    String answer="";
//    String myAnswer = " ";

    public Question_Subjective(String stem, int mark, int difficulty,String answer) {
        this.stem = stem;
        this.mark = mark;
        this.difficulty=difficulty;
        this.answer=answer;
//        this.myAnswer=myAnswer;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    public void setStem(String stem) {
        this.stem = stem;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMark() {
        return mark;
    }
    public int getDifficulty() {
        return difficulty;
    }
    public String getAnswer() {
        return answer;
    }
    public String getStem() {
        return stem;
    }
    public String getQuestion() {
        return stem;
    }

}
