package test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PersonalAccountPage;
import pages.User;
import pages.UserApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalAccountPageTest {

    private WebDriver driver;
    private String email = "john.doe@mail.ru";
    private String password = "password123";
    private String firstName = "John Doe";
    private String userId;
    private String accessToken;
    private UserApi userApi = new UserApi();

    @BeforeEach
    public void setup() {
        // Запускаем браузер
        driver = new ChromeDriver();

        // Регистрация нового пользователя
        User userToCreate = new User(email, password, firstName);
        Response registerResponse = userApi.createUser(userToCreate);
        userId = registerResponse.jsonPath().getString("user.id");

        // Логинимся новым пользователем
        User loginUser = new User(email, password, firstName);
        Response loginResponse = userApi.loginUser(loginUser);
        accessToken = userApi.extractAndFormatToken(loginResponse);
        System.out.println("Access Token: " + accessToken);

        // Открываем главную страницу приложения
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @Test
    public void testLogout() {
        // Вход в систему
        if (!driver.getCurrentUrl().contains("/account")) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
        }

        // Проверяем успешность авторизации
        assertTrue(driver.getCurrentUrl().contains("/account"), "Авторизация не удалась!");

        // Получаем доступ к персональному аккаунту
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        // Выход из системы
        personalAccountPage.clickLogoutButton();

        // Проверяем, что выход прошел успешно
        assertTrue(driver.getCurrentUrl().contains("/login"), "Выход из системы не удался!");
    }

    @Test
    public void testConstructorButton() {
        // Вход в систему (если не выполнен автоматически)
        if (!driver.getCurrentUrl().contains("/account")) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
        }

        // Проверяем успешность авторизации
        assertTrue(driver.getCurrentUrl().contains("/account"), "Авторизация не удалась!");

        // Получаем доступ к персональному аккаунту
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        // Нажимаем кнопку "Конструктор"
        personalAccountPage.clickConstructorButton();

        // Проверяем, что перешли на страницу конструктора
        assertTrue(driver.getCurrentUrl().contains("/constructor"), "Не удалось перейти на страницу конструктора.");
    }

    @AfterEach
    public void teardown() {
        // Закрытие браузера
        driver.quit();

        // Чистка пользователей (при необходимости)
        if (userId != null && !userId.isEmpty()) {
            userApi.deleteUser(userId);
        }
    }
}