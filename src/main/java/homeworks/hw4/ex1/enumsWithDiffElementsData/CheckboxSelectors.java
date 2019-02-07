package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum CheckboxSelectors {
    // TODO nope, you should not put locators here, it should be in PO only !
    // TODO Names will be better without _SELECTOR
    WATER_SELECTOR("label:nth-child(1)"),
    EARTH_SELECTOR("label:nth-child(2)"),
    WIND_SELECTOR("label:nth-child(3)"),
    FIRE_SELECTOR("label:nth-child(4)");
    private String value;

    CheckboxSelectors(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
