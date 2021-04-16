package Teacher.Bean.Question;

public class Question_choice  {
    int kind=0;
    int qid=0;
    String stem=" ";
    int mark=0;
    String optionA="null";
    String optionB="null";
    String optionC="null";
    String optionD="null";
    int myOption=0;
    int difficulty=0;

    public Question_choice(String stem,int mark,int difficulty,String optionA,String optionB,String optionC,String optionD,int myOption){
        this.stem=stem;
        this.mark=mark;
        this.difficulty=difficulty;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.myOption=myOption;

    }

    public void setStem(String stem) {
        this.stem = stem;
    }
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
    public void setMyOption(int myOption) {
        this.myOption = myOption;
    }
    public void setMark(int mark) { this.mark = mark; }
    public int getDifficulty() { return difficulty; }

    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }
    public int getMark() {
        return mark;
    }
    public int getQid() { return qid; }
    public int getKind() { return kind; }
    public int getMyOption() {
        return myOption;
    }
    public String getStem() {
        return stem;
    }
    public String toString() {
        return "  "+stem+"\n  A:"+optionA+"\n  B:"+optionB+"\n  C:"+optionC+"\n  D:"+optionD;
    }
}