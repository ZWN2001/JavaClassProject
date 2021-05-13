package Teacher.Bean;

import Teacher.Function.MyNumberFormat;

import java.util.ArrayList;

/**
 * @ClassName:
 * @Description: 用于统计试卷情况
 * @parms:
 * @author 赵炜宁
 * @date
 *
 */
public class Statistician_SelfAdd {

    private   int choseNum=0;
    private  int allMark=0;
    private double difficulty=0;
    private String paperName="";
    private String examTime="";
    private  ArrayList<Integer> myChoice=new ArrayList<>();
    private  ArrayList<Integer>myMultiChoice=new ArrayList<>();
    private  ArrayList<Integer>myJudge=new ArrayList<>();
    private  ArrayList<Integer>mySubjective=new ArrayList<>();
    private  ArrayList<Integer> myChoiceIDList=new ArrayList<>();
    private  ArrayList<Integer>myMultiChoiceIDList=new ArrayList<>();
    private  ArrayList<Integer>myJudgeIDList=new ArrayList<>();
    private  ArrayList<Integer>mySubjectiveIDList=new ArrayList<>();

    public void addChoseNum() {
        this.choseNum++;
    }
    public void removeChoseNum(){
        this.choseNum--;
    }
    public int getChoseNum() {
        return choseNum;
    }

    public int getAllMark() {
        return allMark;
    }
    public void addMark(int mark) {
        this.allMark += mark;
    }
    public void reduceMark(int mark){
        this.allMark -= mark;
    }

    public String getPaperName() {
        return paperName;
    }
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
    public String getExamTime() {
        return examTime;
    }
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public void difficulty_add(int difficulty1){
        difficulty+=difficulty1;
        difficulty/=choseNum;
        difficulty= MyNumberFormat.formatDouble(difficulty);
    }
    public void difficulty_reduce(double difficulty1){
        if (myChoice.size()>0){
            difficulty-=difficulty1;
            difficulty/=choseNum;
            difficulty= MyNumberFormat.formatDouble(difficulty);
        }else {
            difficulty=0;
        }
    }
    public double getDifficulty() {
        return difficulty;
    }

    public ArrayList<Integer> getMyChoice() {
        return myChoice;
    }
    public void addMyChoice(Integer qid) {
        this.myChoice.add(qid);
    }
    public void removeChoice(Integer qid){
        if (this.myChoice.contains(qid)){
            this.myChoice.remove(qid);
        }
    }

    public ArrayList<Integer> getMyMultiChoice() {
        return myMultiChoice;
    }
    public void addMyMultiChoice(Integer qid) {
        this.myMultiChoice.add(qid);
    }
    public void removeMultiChoice(Integer qid){
        if (this.myMultiChoice.contains(qid)){
            this.myMultiChoice.remove(qid);
        }
    }

    public ArrayList<Integer> getMyJudge() {
        return myJudge;
    }
    public void addMyJudge(Integer qid) {
        this.myJudge.add(qid);
    }
    public void removeJudge(Integer qid){
        if (this.myJudge.contains(qid)){
            this.myJudge.remove(qid);
        }
    }

    public ArrayList<Integer> getMySubjective() {
        return mySubjective;
    }
    public void addMySubjective(Integer qid) {
        this.mySubjective.add(qid);
    }
    public void removeSubjective(Integer qid){
        if (this.myChoice.contains(qid)){
            this.myChoice.remove(qid);
        }
    }

    public ArrayList<Integer> getMyChoiceIDList() {
        return myChoiceIDList;
    }
    public void addMyChoiceIDList(Integer id) {
        this.myChoiceIDList.add(id);
    }
    public void removeChoiceIDList(Integer id){
        if (this.myChoiceIDList.contains(id)){
            this.myChoiceIDList.remove(id);
        }
    }

    public ArrayList<Integer> getMyMultiChoiceIDList() {
        return myMultiChoiceIDList;
    }
    public void addMyMultiChoiceIDList(Integer id) {
        this.myMultiChoiceIDList.add(id);
    }
    public void removeMultiChoiceIDList(Integer id){
        if (this.myMultiChoiceIDList.contains(id)){
            this.myMultiChoiceIDList.remove(id);
        }
    }

    public ArrayList<Integer> getMyJudgeIDList() {
        return myJudgeIDList;
    }
    public void addMyJudgeIDList(Integer id) {
        this.myJudgeIDList.add(id);
    }
    public void removeJudgeIDList(Integer id){
        if (this.myJudgeIDList.contains(id)){
            this.myJudgeIDList.remove(id);
        }
    }

    public ArrayList<Integer> getMySubjectiveIDList() {
        return mySubjectiveIDList;
    }
    public void addMySubjectiveIDList(Integer id) {
        this.mySubjectiveIDList.add(id);
    }
    public void removeSubjectiveIDList(Integer id){
        if (this.myChoiceIDList.contains(id)){
            this.myChoiceIDList.remove(id);
        }
    }


    @Override
    public String toString() {
        return "Statistician_SelfAdd{" +
                "choseNum=" + choseNum +
                ", allMark=" + allMark +"\n"+
                ", myChoice=" + myChoice +
                ", myMultiChoice=" + myMultiChoice +
                ", myJudge=" + myJudge +
                ", mySubjective=" + mySubjective +"\n"+
                ", myChoiceIDList=" + myChoiceIDList +
                ", myMultiChoiceIDList=" + myMultiChoiceIDList +
                ", myJudgeIDList=" + myJudgeIDList +
                ", mySubjectiveIDList=" + mySubjectiveIDList +
                '}';
    }
}
