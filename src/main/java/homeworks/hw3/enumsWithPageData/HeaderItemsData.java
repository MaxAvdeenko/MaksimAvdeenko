package homeworks.hw3.enumsWithPageData;

public enum  HeaderItemsData {
    HOME_TEXT("HOME"),
    CONTACTS_TEXT("CONTACT FORM"),
    SERCICE_TEXT("SERVICE"),
    METALS_TEXT("METALS & COLORS");

    private String value;

    HeaderItemsData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
