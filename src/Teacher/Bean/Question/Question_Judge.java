package Teacher.Bean.Question;

public class Question_Judge extends Question{
    private int id=0;
    private String stem="null";
    private int mark = 0;
    private final String answer;
    private int difficulty=0;
    public Question_Judge(String stem, int mark, int difficulty, String answer) {
        this.stem = stem;
        this.mark = mark;
        this.difficulty=difficulty;
        this.answer=answer;
    }
    public Question_Judge(int id,String stem, int mark, int difficulty, String answer) {
        this.id=id;
        this.stem = stem;
        this.mark = mark;
        this.difficulty=difficulty;
        this.answer=answer;
    }

    public int getId() {
        return id;
    }
    public void setStem(String stem) {
        this.stem = stem;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    public int getMark() {
        return mark;
    }
    public String getStem() {
        return stem;
    }
    public String toString() {
        return stem;
    }
    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public String getAnswer() {
        return answer;
    }
}
