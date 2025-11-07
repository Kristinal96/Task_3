package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;


public class ForgotPasswordPage {
    private WebDriver driver;

    // Связываем элемент с локатором
    @FindBy(xpath = ForgotPasswordPageLocators.LOGIN_LINK)
    private WebElement loginLink;


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Метод для клика по ссылке Войти")
    public void clickLoginLink() {
        loginLink.click();
    }
}