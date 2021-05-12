package Teacher.Test;



public class PaperMark {
    String name;
    int obj;
    int sub;
    int all;

    public PaperMark() {
    }

    public PaperMark( String name, int obj, int sub, int all) {
        this.name = name;
        this.obj = obj;
        this.sub = sub;
        this.all = all;
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


}
