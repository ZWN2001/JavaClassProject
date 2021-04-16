package Teacher.Bean.Question;

public class Question_judge {
    int kind = 1;
    int qid = 0;
    String stem="null";
    int mark = 0;
    int myJudge = 2;
    int difficulty=0;
    public Question_judge(String stem, int mark,int difficulty,int myJudge) {
        this.stem = stem;
        this.mark = mark;
        this.difficulty=difficulty;
        this.myJudge=myJudge;
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

}
