package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;


    @FindBy(xpath = MainPageLocators.PERSONAL_ACCOUNT_BUTTON)
    private WebElement personalAccountButton;

    @FindBy(xpath = MainPageLocators.LOGIN_BUTTON)
    private WebElement loginButton;

    @FindBy(xpath = MainPageLocators.CONSTRUCTOR_BUTTON)
    private WebElement constructorButton;

    @FindBy(xpath = MainPageLocators.BUNS_BUTTON)
    private WebElement bunsButton;

    @FindBy(xpath = MainPageLocators.SAUCE_BUTTON)
    private WebElement sauceButton;

    @FindBy(xpath = MainPageLocators.FILLINGS_BUTTON)
    private WebElement fillingsButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("clickPersonalAccountButton")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }
    @Step("clickLoginButton")
    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickBunsButton() {
        bunsButton.click();
    }

    public void clickSauceButton() {
        sauceButton.click();
    }

    public void clickFillingsButton() {
        fillingsButton.click();
    }
    // Геттеры для доступа к элементам

    public WebElement getBunsButton() {
        return bunsButton;
    }

    public WebElement getSauceButton() {
        return sauceButton;
    }

    public WebElement getFillingsButton() {
        return fillingsButton;
    }
}