package Teacher.Bean;

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
    private  ArrayList<Integer> myChoice=new ArrayList<>();
    private  ArrayList<Integer>myMultiChoice=new ArrayList<>();
    private  ArrayList<Integer>myJudge=new ArrayList<>();
    private  ArrayList<Integer>mySubjective=new ArrayList<>();

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
    public int addMark(int mark) {
        return this.allMark+=mark;
    }
    public int reduceMark(int mark){
        return this.allMark-=mark;
    }

    public ArrayList<Integer> getMyChoice() {
        return myChoice;
    }
    public void addMyChoice(Integer id) {
        this.myChoice.add(id);
    }
    public void removeChoice(Integer id){
        if (this.myChoice.contains(id)){
            this.myChoice.remove(id);
        }
    }

    public ArrayList<Integer> getMyMultiChoice() {
        return myMultiChoice;
    }
    public void addMyMultiChoice(Integer id) {
        this.myMultiChoice.add(id);
    }
    public void removeMultiChoice(Integer id){
        if (this.myMultiChoice.contains(id)){
            this.myMultiChoice.remove(id);
        }
    }
    public ArrayList<Integer> getMyJudge() {
        return myJudge;
    }
    public void addMyJudge(Integer id) {
        this.myJudge.add(id);
    }
    public void removeJudge(Integer id){
        if (this.myJudge.contains(id)){
            this.myJudge.remove(id);
        }
    }
    public ArrayList<Integer> getMySubjective() {
        return mySubjective;
    }
    public void addMySubjective(Integer id) {
        this.mySubjective.add(id);
    }
    public void removeSubject(Integer id){
        if (this.myChoice.contains(id)){
            this.myChoice.remove(id);
        }
    }

    @Override
    public String toString() {
        return "Statistician{" +
                "choseNum=" + choseNum +
                ", allMark=" + allMark +
                ", myChoice=" + myChoice +
                ", myMultiChoice=" + myMultiChoice +
                ", myJudge=" + myJudge +
                ", mySubjective=" + mySubjective +
                '}';
    }
}
