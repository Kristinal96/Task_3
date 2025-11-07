package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class PersonalAccountPage {
    private WebDriver driver;

        // Привязываем элементы к соответствующим локаторам
        @FindBy(xpath = PersonalAccountPageLocators.LOGOUT_BUTTON)
        private WebElement logoutButton;

        @FindBy(xpath = PersonalAccountPageLocators.CONSTRUCTOR_BUTTON)
        private WebElement constructorButton;

        // Конструктор для инициализации страницы
        public PersonalAccountPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
    @Step("Метод для выхода из аккаунта")
        public void clickLogoutButton() {
            logoutButton.click();
        }
    @Step("Метод для возврата к конструктору")
        public void clickConstructorButton() {
            constructorButton.click();
        }
}
