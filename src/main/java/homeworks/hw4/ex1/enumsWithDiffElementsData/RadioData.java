package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum RadioData {
    // TODO Same story, locators, naming. Tale a look on CheckboxSelectors
    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    SELEN("SELEN");
    private String value;

    RadioData (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
