package homeworks.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homeworks.hw7.pages.JdiIndexPage;
import homeworks.hw7.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    @Url("index.html")
    public static JdiIndexPage jdiIndexPage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;
}
