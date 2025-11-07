package test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DriverFactory;
import pages.MainPage;
import pages.MainPageLocators;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        String browserName = "yandex"; // Здесь можно передать имя браузера
        driver = DriverFactory.getDriver(browserName);
        driver.get("https://stellarburgers.education-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testPersonalAccountButton() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.education-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        // Проверка, что мы перешли на страницу входа
        assertTrue(driver.getCurrentUrl().contains("/login"));

        driver.quit();
    }
}