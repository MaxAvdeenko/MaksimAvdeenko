package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum RadioData {
    // TODO Same story, locators, naming. Tale a look on CheckboxSelectors
    RADIO_1("GOLD"),
    RADIO_2("SILVER"),
    RADIO_3("BRONZE"),
    RADIO_4("SELEN");
    private String value;

    RadioData (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
