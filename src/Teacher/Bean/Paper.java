package Teacher.Bean;
/**
 * @ClassName: paper
 * @Description: 实体化试卷类
 * @parms: questions 存放题目的id
 * @author 赵炜宁
 * @date 2021.4.13
 *
 */
public class Paper {
    String title;
    int mark;
    int [] questions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int[] getQuestions() {
        return questions;
    }

    public void setQuestions(int[] questions) {
        this.questions = questions;
    }

}
