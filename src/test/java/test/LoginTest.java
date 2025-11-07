package test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import pages.ForgotPasswordPageLocators;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
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
    public void testLoginFromMainPage() {
        // Получаем объект главной страницы
        MainPage mainPage = new MainPage(driver);
        // Нажимаем кнопку "Войти в аккаунт"
        mainPage.clickLoginButton();
        // Проверяем, что мы оказались на странице входа
        assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test
    public void testLoginFromPersonalAccountButton() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.education-services.ru/");
        // Получаем объект главной страницы
        MainPage mainPage = new MainPage(driver);
        // Нажимаем кнопку "Личный кабинет"
        mainPage.clickPersonalAccountButton();
        // Проверяем, что мы оказались на странице входа
        assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test
    public void testLoginFromRegistrationPage() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.education-services.ru/register");
        // Получаем объект страницы регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        // Нажимаем кнопку "Войти" на странице регистрации
        registrationPage.clickLoginLink();
        // Проверяем, что мы оказались на странице входа
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void testLoginFromForgotPasswordPage() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.education-services.ru/forgot-password");
        // Получаем объект страницы восстановления пароля
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        // Нажимаем кнопку "Войти" на странице восстановления пароля
        forgotPasswordPage.clickLoginLink();
        // Проверяем, что мы оказались на странице входа
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit(); // Завершаем работу браузера после завершения тестов
        }
    }
}