package test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DriverFactory;
import pages.MainPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorPageTest {
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
    public void testBunsButtonIsClickable() {
        assertTrue(mainPage.getBunsButton().isDisplayed());
        assertTrue(mainPage.getBunsButton().isEnabled());
    }

    @Test
    public void testSauceButtonIsClickable() {
        assertTrue(mainPage.getSauceButton().isDisplayed());
        assertTrue(mainPage.getSauceButton().isEnabled());
    }

    @Test
    public void testFillingsButtonIsClickable() {
        assertTrue(mainPage.getFillingsButton().isDisplayed());
        assertTrue(mainPage.getFillingsButton().isEnabled());
    }


    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit(); // Завершаем работу браузера после завершения тестов
        }
    }
}