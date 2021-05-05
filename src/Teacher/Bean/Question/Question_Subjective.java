package Teacher.Bean.Question;

public class Question_Subjective extends Question{
    private int id=0;
    private String stem;
    private int mark = 0;
    private int difficulty=0;
    private String answer="";

    public Question_Subjective(String stem, int mark, int difficulty,String answer) {
        this.stem = stem;
        this.mark = mark;
        this.difficulty=difficulty;
        this.answer=answer;
    }
    public Question_Subjective(int id,String stem, int mark, int difficulty,String answer) {
        this.id=id;
        this.stem = stem;
        this.mark = mark;
        this.difficulty=difficulty;
        this.answer=answer;
    }

    public int getId() {
        return id;
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
