package Teacher.Bean;

public class Teacher {

    String account;
    String name;
    String subject;
    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
    
    public String toString(){
        return name+"("+account+")";
    }

}
