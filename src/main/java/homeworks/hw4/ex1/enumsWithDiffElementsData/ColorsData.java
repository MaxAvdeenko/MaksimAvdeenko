package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum ColorsData {
    // TODO Oh my, why don't you named enums like RED, BLUE, etc ?
    COLOR_1("RED"),
    COLOR_2("GREEN"),
    COLOR_3("BLUE"),
    COLOR_4("YELLOW");
    private String value;

    ColorsData (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
