package homeworks.hw7.enums;

public enum Odd {

    ONE("1"),
    TREE("3"),
    FIVE("5"),
    SEVEN("7");
    private String value;

    Odd(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

