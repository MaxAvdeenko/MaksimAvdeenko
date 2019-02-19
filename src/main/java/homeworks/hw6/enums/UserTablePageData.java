package homeworks.hw6.enums;

public enum  UserTablePageData {
    USER_TABLE_HTML_URL("https://epam.github.io/JDI/user-table.html"),
    USER_TABLE_PAGE_TITLE("User Table");

    private String value;

    UserTablePageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
