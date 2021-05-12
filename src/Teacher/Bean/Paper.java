package Teacher.Bean;

import java.awt.*;

/**
 * @ClassName: paper
 * @Description: 实体化试卷类
 * @parms: questions 存放题目的id
 * @author 赵炜宁
 * @date 2021.4.13
 *
 */
public class Paper {
    private int id;
    private String title;
    private int mark;
    private int ownerID;
    private String owner;
    private String time;
    private int examTime;//考试时长
    private String questions;//JSONString
    private double difficulty;
    public Paper(String title,int mark,double difficulty,String time,int examTime,String owner,int ownerID,String questions){
        this.title=title;
        this.mark=mark;
        this.time=time;
        this.examTime=examTime;
        this.owner=owner;
        this.ownerID=ownerID;
        this.questions=questions;
        this.difficulty=difficulty;
    }
        public Paper(String title, int ownerID, String owner, String time, double difficulty) {
        this.title = title;
        this.ownerID = ownerID;
        this.owner = owner;
        this.time = time;
        this.difficulty = difficulty;
    }
    public Paper(int id,String title,int mark,double difficulty,String time,int examTime,String owner,int ownerID,String questions){
        this.id=id;
        this.title=title;
        this.mark=mark;
        this.time=time;
        this.examTime=examTime;
        this.owner=owner;
        this.ownerID=ownerID;
        this.questions=questions;
        this.difficulty=difficulty;
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
    public int getOwnerID() {
        return ownerID;
    }
    public void setOwnerID(int ownerID) {
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
    public int getExamTime() {
        return examTime;
    }
    public void setExamTime(int examTime) {
        this.examTime = examTime;
    }
    public String getQuestions() {
        return questions;
    }
    public void setQuestions(String questions) {
        this.questions = questions;
    }
    public double getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", mark=" + mark +
                ", ownerID=" + ownerID +
                ", owner='" + owner + '\'' +
                ", time='" + time + '\'' +
                ", examTime=" + examTime +
                ", questions='" + questions + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
