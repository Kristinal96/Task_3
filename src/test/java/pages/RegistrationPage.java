package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(css = ".input__textfield")
    private WebElement nameInputClik;

    // Поле ввода имени
    @FindBy(css = ".input__textfield")
    private WebElement nameInput;

    // Поле ввода электронной почты
    @FindBy(xpath = "(//input[@name='name'])[2]")
    private WebElement emailInput;

    // Поле ввода пароля
    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    // Кнопка "Зарегистрироваться"
    @FindBy(xpath = "//button[.='Зарегистрироваться']")
    private WebElement registerButton;

    // Ссылка "Войти"
    @FindBy(css = "a[href='/login']")
    private WebElement loginLink;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Метод для перехода на страницу входа")
    public void clickLoginLink() {
        loginLink.click();
    }
    @Step("Метод для ввода Name")
    public void enterName(String name) {
        nameInputClik.click();
        nameInput.sendKeys(name);
    }
    @Step("Метод для ввода Email")
    public void enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }
    @Step("Метод для ввода Password")
    public void enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }
    @Step("Нажатие на регистрацию")
    public void clickRegisterButton() {
        registerButton.click();
    }
}