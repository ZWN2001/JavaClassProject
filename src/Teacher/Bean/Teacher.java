package Teacher.Bean;

public class Teacher {

    private final String account;
    private final String name;
    private String password;
    private String image;

    public Teacher(String account, String name) {
        this.account = account;
        this.name = name;
    }

    public Teacher(String account, String name, String password) {
        this.account = account;
        this.name = name;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    
    public String toString(){
        return name+"("+ account +")";
    }

}
