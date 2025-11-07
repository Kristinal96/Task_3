package pages;

import org.openqa.selenium.WebDriver;

public class PersonalAccountPageLocators {
    private WebDriver driver;
    // Локатор для кнопки "Выход"
    public static final String LOGOUT_BUTTON = "//button[contains(text(), 'Выход')]";
    // Локатор для кнопки "Конструктор"
    public static final String CONSTRUCTOR_BUTTON = "//a[contains(@href, '/') and contains(text(), 'Конструктор')]";
}