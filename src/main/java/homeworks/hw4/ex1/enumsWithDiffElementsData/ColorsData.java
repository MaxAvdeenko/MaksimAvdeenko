package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum ColorsData {
    // TODO Oh my, why don't you named enums like RED, BLUE, etc ?
    RED("RED"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    YELLOW("YELLOW");
    private String value;

    ColorsData (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
