package test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DriverFactory;
import pages.MainPage;
import pages.RegistrationPage;


public class RegistrationTest {
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
    public void testSuccessfulRegistration() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.education-services.ru/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterName("Test User");
        registrationPage.enterEmail("test@example.com");
        registrationPage.enterPassword("password123");
        registrationPage.clickRegisterButton();

        driver.quit();
    }

    @Test
    public void testRegistrationWithInvalidPassword() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.education-services.ru/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterName("Test User");
        registrationPage.enterEmail("test@example.com");
        registrationPage.enterPassword("123"); // Короткий пароль
        registrationPage.clickRegisterButton();

        driver.quit();
    }
}