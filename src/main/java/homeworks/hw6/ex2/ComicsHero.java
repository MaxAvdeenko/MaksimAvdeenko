package homeworks.hw6.ex2;

public class ComicsHero {
    private String number;
    private String user;
    private String description;

    public ComicsHero(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }
}
