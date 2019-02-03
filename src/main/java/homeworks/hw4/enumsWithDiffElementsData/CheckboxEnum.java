package homeworks.hw4.enumsWithDiffElementsData;

public enum CheckboxEnum {
    WATER_SELECTOR("label:nth-child(1)"),
    EARTH_SELECTOR("label:nth-child(2)"),
    WIND_SELECTOR("label:nth-child(3)"),
    FIRE_SELECTOR("label:nth-child(4)");
    private String value;

    CheckboxEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
