package Teacher.Bean;

public class Statistician_AutoAdd {
    int allChoseNum=0;
    double averageDifficulty=0;
    private String paperName="";
    private String examTime="";
    public int getAllChoseNum() {
        return allChoseNum;
    }
    public void setAllChoseNum(int allChoseNum) {
        this.allChoseNum = allChoseNum;
    }
    public double getAverageDifficulty() {
        return averageDifficulty;
    }
    public void setAverageDifficulty(double averageDifficulty) {
        this.averageDifficulty = averageDifficulty;
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
}
