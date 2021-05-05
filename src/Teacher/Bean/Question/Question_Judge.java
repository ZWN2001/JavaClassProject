package Teacher.Bean.Question;

public class Question_Judge extends Question{
    int kind = 1;
    int id=0;
    int qid = 0;
    String stem="null";
    int mark = 0;
    String answer;
    int difficulty=0;
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
    public int getQid() {
        return qid;
    }
    public int getKind() {
        return kind;
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
