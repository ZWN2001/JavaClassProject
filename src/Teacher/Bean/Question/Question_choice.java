package Teacher.Bean.Question;

public class Question_choice extends Question {

    String stem=" ";
    int kind=0;
    String optionA="null";
    String optionB="null";
    String optionC="null";
    String optionD="null";
    int myOption=4;
    int mark=0;

    String choiceQuestion="  "+stem+"\n  A:"+optionA+"\n  B:"+optionB+"\n  C:"+optionC+"\n  D:"+optionD;

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

    public int getMark() {
        return mark;
    }
    public int getMyOption() {
        return myOption;
    }
    @Override
    public String getStem() {
        return stem;
    }
    @Override
    public String getQuestion() {
        return choiceQuestion;
    }


    public Question_choice(){ }
    public Question_choice(String stem){ this.stem=stem; }
    public Question_choice(String stem,int mark){ this.stem=stem;this.mark=mark; }
}