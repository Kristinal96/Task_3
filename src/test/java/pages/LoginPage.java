package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class LoginPage {
    private WebDriver driver;
    // Элементы привязаны к строковым локаторам
    @FindBy(css = LoginPageLocators.EMAIL_INPUT)
    private WebElement emailInput;

    @FindBy(css = LoginPageLocators.PASSWORD_INPUT)
    private WebElement passwordInput;

    @FindBy(css = LoginPageLocators.LOGIN_BUTTON)
    private WebElement loginButton;

    // Конструктор страницы
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Метод для заполнения формы входа Email")
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    @Step("Метод для заполнения формы входа Password")
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    @Step("Метод для заполнения формы входа Login")
    public void clickLoginButton() {
        loginButton.click();
    }
    @Step("Закрытие драйвера")
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}