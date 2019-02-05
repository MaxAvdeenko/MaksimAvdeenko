package homeworks.hw4.ex2;

public enum DatesPageData {
    DATES_HTML_URL("https://epam.github.io/JDI/dates.html"),
    DATES_PAGE_TITLE("Dates"),
    LEFT_SLIDER("From"),
    RIGHT_SLIDER("To");

    public String value;

    DatesPageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
