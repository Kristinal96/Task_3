package pages;

import org.openqa.selenium.WebDriver;

public class MainPageLocators {

    private WebDriver driver;

    public static final String PERSONAL_ACCOUNT_BUTTON = "//a[contains(@href, '/account')]";
    public static final String LOGIN_BUTTON = "//button[contains(text(), 'Войти в аккаунт')]";
    public static final String CONSTRUCTOR_BUTTON = "//a[contains(@href, '/') and contains(text(), 'Конструктор')]";
    public static final String BUNS_BUTTON = "//span[contains(text(), 'Булки')]";
    public static final String SAUCE_BUTTON = "//span[contains(text(), 'Соус')]";
    public static final String FILLINGS_BUTTON = "//span[contains(text(), 'Начинки')]";
}