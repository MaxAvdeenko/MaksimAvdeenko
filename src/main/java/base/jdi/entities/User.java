package base.jdi.entities;

public class User {

    public static User PITER = new User("epam", "1234", "PITER CHAILOVSKII");
    public String login;
    public String password;
    public String fullname;

    public User(String login, String password, String fullname) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
    }


}
