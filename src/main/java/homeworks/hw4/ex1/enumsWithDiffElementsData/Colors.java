package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum Colors {
    RED("RED"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    YELLOW("YELLOW");
    private String value;

    Colors(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
