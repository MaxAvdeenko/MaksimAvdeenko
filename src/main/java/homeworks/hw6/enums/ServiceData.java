package homeworks.hw6.enums;

public enum  ServiceData {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_PAGES("Table with pages"),
    DIFFERENT("Different elements"),
    PERFORMANCE("Performance");

    private String value;

    ServiceData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
