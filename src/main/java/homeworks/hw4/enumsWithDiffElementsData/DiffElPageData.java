package homeworks.hw4.enumsWithDiffElementsData;

public enum DiffElPageData {
    DIFFEl_HTML_URL("https://epam.github.io/JDI/different-elements.html"),
    DIFFEL_PAGE_TITLE("Different Elements");
    private String value;

    DiffElPageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
