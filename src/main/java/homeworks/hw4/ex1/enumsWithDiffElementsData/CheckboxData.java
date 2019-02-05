package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum CheckboxData {
    CHECKBOX_1("WATER"),
    CHECKBOX_2("EARTH"),
    CHECKBOX_3("WIND"),
    CHECKBOX_4("FIRE");
    private String value;

    CheckboxData (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
