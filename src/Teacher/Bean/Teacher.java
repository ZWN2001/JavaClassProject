package Teacher.Bean;

public class Teacher {

    private final String ID;
    private final String name;
    private  String subject;

    public Teacher(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
    
    public String toString(){
        return name+"("+ID+")";
    }

}
