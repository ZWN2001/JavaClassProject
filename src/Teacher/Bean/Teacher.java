package Teacher.Bean;

public class Teacher {
    public Teacher(String account, String name) {
        this.account = account;
        this.name = name;
    }

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
