package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "yandex":
                YandexDriverOptions yandexOptions = new YandexDriverOptions();
                yandexOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                driver = new YandexDriver(yandexOptions);
                break;
            default:
                throw new IllegalArgumentException("Не поддерживаемый браузер: " + browserName);
        }
        return driver;
    }
}