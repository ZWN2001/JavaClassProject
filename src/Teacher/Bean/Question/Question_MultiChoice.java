package Teacher.Bean.Question;

public class Question_MultiChoice extends Question{
    int kind=0;
    int id;
    int qid=0;
    String stem=" ";
    int mark=0;
    String optionA="null";
    String optionB="null";
    String optionC="null";
    String optionD="null";
    String answer="A";
    int difficulty=0;

    public Question_MultiChoice(String stem, int mark, int difficulty, String optionA, String optionB, String optionC, String optionD,  String answer){
        this.stem=stem;
        this.mark=mark;
        this.difficulty=difficulty;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.answer=answer;
    }
    public Question_MultiChoice(int id,String stem, int mark, int difficulty, String optionA, String optionB, String optionC, String optionD,  String answer){
        this.id=id;
        this.stem=stem;
        this.mark=mark;
        this.difficulty=difficulty;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.answer=answer;
    }

    public int getId() {
        return id;
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
    public void setMark(int mark) { this.mark = mark; }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }
    public int getDifficulty() { return difficulty; }
    public String getAnswer() {
        return answer;
    }
    public int getMark() {
        return mark;
    }
    public int getQid() { return qid; }
    public int getKind() { return kind; }

    public String getOptionA() {
        return optionA;
    }
    public String getOptionB() {
        return optionB;
    }
    public String getOptionC() {
        return optionC;
    }
    public String getOptionD() {
        return optionD;
    }

    //    public String getMyOption() {
//        return myOption;
//    }
    public String getStem() {
        return stem;
    }
    public String toString() {
        return "  "+stem+"\n  A:"+optionA+"\n  B:"+optionB+"\n  C:"+optionC+"\n  D:"+optionD;
    }
}
