package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum NatureElements {
    WATER("WATER"),
    EARTH("EARTH"),
    WIND("WIND"),
    FIRE("FIRE");
    private String value;

    NatureElements(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
