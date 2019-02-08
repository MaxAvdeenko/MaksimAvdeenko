package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum CheckboxData {
    WATER("WATER"),
    EARTH("EARTH"),
    WIND("WIND"),
    FIRE("FIRE");
    private String value;

    CheckboxData (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
