package pages;

import org.openqa.selenium.WebDriver;

public class User {
    private WebDriver driver;
    private String email;
    private String password;
    private String firstName;

    public User(String email, String password, String firstName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
    }

    // Геттеры и сеттеры
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }

}