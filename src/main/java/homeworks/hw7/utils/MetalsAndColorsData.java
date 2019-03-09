package homeworks.hw7.utils;

public enum MetalsAndColorsData {
    METALS_TEXT("METALS & COLORS"),
    METALS_TITLE("Metal and Colors");

    private String value;

    MetalsAndColorsData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
