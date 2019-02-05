package homeworks.hw4.enumsWithDiffElementsData;

public enum DiffElPageData {
    DIFFEl_HTML_URL("https://epam.github.io/JDI/different-elements.html"),
    DIFFEL_PAGE_TITLE("Different Elements"),
    WATER_SELECTOR("label:nth-child(1)"),
    EARTH_SELECTOR("label:nth-child(2)"),
    WIND_SELECTOR("label:nth-child(3)"),
    FIRE_SELECTOR("label:nth-child(4)");
    private String value;

    DiffElPageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
