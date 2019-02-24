package homeworks.hw7.enums;

public enum Even {
    TWO("2"),
    FOUR("4"),
    SIX("6"),
    EIGHT("8");
    private String value;

    Even(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
