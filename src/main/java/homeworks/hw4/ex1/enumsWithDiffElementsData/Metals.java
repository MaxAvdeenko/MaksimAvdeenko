package homeworks.hw4.ex1.enumsWithDiffElementsData;

public enum Metals {
    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    SELEN("SELEN");
    private String value;

    Metals(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
