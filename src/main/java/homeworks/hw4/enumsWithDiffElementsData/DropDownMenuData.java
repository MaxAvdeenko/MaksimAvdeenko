package homeworks.hw4.enumsWithDiffElementsData;

public enum DropDownMenuData {
    DROPDOWN_1("SUPPORT"),
    DROPDOWN_2("DATES"),
    DROPDOWN_3("COMPLEX TABLE"),
    DROPDOWN_4("SIMPLE TABLE"),
    DROPDOWN_5("USER TABLE"),
    DROPDOWN_6("TABLE WITH PAGES"),
    DROPDOWN_7("DIFFERENT ELEMENTS"),
    DROPDOWN_8("PERFORMANCE");
    private String value;

    DropDownMenuData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
