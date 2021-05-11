package Teacher.Test;

public class AvailableQuestion {
    String answerText;
    int mark;

    public AvailableQuestion(String answerText, int mark) {
        this.answerText = answerText;
        this.mark = mark;
    }
    public static AvailableQuestion[] getAvailableQuestion(){
        AvailableQuestion[] a=new AvailableQuestion[20];
        for (int i=0;i<20;i++){
            a[i]=new AvailableQuestion("测试"+i,0);
        }
        return a;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    public String getAnswerText() {
        return answerText;
    }
}
