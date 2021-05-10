package Teacher.Test;



public class PaperMark {
    int paperID;
    String name;
    int obj;
    int sub;
    int all;

    public PaperMark() {
    }

    public PaperMark(int paperID, String name, int obj, int sub, int all) {
        this.paperID = paperID;
        this.name = name;
        this.obj = obj;
        this.sub = sub;
        this.all = all;
    }

    public int getPaperID() {
        return paperID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getObj() {
        return obj;
    }
    public void setObj(int obj) {
        this.obj = obj;
    }
    public int getSub() {
        return sub;
    }
    public void setSub(int sub) {
        this.sub = sub;
    }
    public int getAll() {
        return all;
    }
    public void setAll(int all) {
        this.all = all;
    }

    public static PaperMark[] getTestPaperMark(){
        PaperMark[] paperMarks=new PaperMark[10];
        for (int i=0;i<10;i++){
            paperMarks[i]=new PaperMark(i+1,"a"+i,2*i,3*i,5*i);
        }
        return paperMarks;
    }
}
