package homeworks.hw4.enumsWithDiffElementsData;

public enum CheckboxSelectors {
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
