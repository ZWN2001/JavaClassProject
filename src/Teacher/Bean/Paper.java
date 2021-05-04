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
    int id;
    String title;
    int mark;
    String ownerID;
    String owner;
    String time;
    String examTime;//考试时长
    String questions;
    public Paper(int id,String title,int mark,String time,String examTime,String owner,String ownerID,String questions){
        this.id=id;
        this.title=title;
        this.mark=mark;
        this.time=time;
        this.examTime=examTime;
        this.owner=owner;
        this.ownerID=ownerID;
        this.questions=questions;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public String getOwnerID() {
        return ownerID;
    }
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getExamTime() {
        return examTime;
    }
    public void setExamTime(String endTime) {
        this.examTime = examTime;
    }
    public String getQuestions() {
        return questions;
    }
    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
