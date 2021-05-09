package Teacher.Bean;

public class Statistician_AutoAdd {
    private int allChoseNum=0;
    private double averageDifficulty=0;


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

    @Override
    public String toString() {
        return "Statistician_AutoAdd{" +
                "allChoseNum=" + allChoseNum +
                ", averageDifficulty=" + averageDifficulty +
                '}';
    }
}
