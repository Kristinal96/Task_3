package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageLocators {
    private WebDriver driver;

    // Локатор для клика на поле ввода имени
    public static final By NAME_INPUT_CLICK = By.cssSelector(".input__textfield");

        // Локатор для поля ввода имени
        public static final By NAME_INPUT = By.cssSelector(".input__input.text_type_main-default[name='name']");

        // Локатор для поля ввода Email
        public static final By EMAIL_INPUT = By.xpath("(//input[@name='name'])[2]");  // Поле ввода имени

        // Локатор для поля ввода пароля
        public static final By PASSWORD_INPUT = By.cssSelector("input[type='password']");

        // Локатор для кнопки "Зарегистрироваться"
        public static final By REGISTER_BUTTON = By.cssSelector("//button[.='Зарегистрироваться']");

        // Локатор для сообщения об ошибке
        public static final By ERROR_MESSAGE = By.xpath("//p[contains(text(), 'Пароль должен быть не менее 6 символов')]");

        // Новый локатор для ссылки "Войти"
        public static final By LOGIN_LINK = By.cssSelector("a[href='/login']");
    }
