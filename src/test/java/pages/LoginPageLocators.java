package pages;

import org.openqa.selenium.WebDriver;

public class LoginPageLocators {
    private WebDriver driver;

    // Локатор для поля ввода E-mail
    public static final String EMAIL_INPUT = ".input__textfield[type='text']";
    // Локатор для поля ввода пароля
    public static final String PASSWORD_INPUT = "input[type='password']";
    // Локатор для кнопки "Войти"
    public static final String LOGIN_BUTTON = ".button_button_type_primary__1O7Bx";;
    // Локатор для сообщения об успешной авторизации
    public static final String SUCCESS_MESSAGE = "//p[contains(text(), 'Вы успешно вошли')]";
    // Локатор для сообщения об ошибке (например, для неверного пароля)
    public static final String ERROR_MESSAGE = "//p[contains(text(), 'Неверный логин или пароль')]";
}