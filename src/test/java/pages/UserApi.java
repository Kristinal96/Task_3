package pages;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class UserApi {
    private WebDriver driver;
    @Step("Создание пользователя")
    public Response createUser(User user) {
        return RestAssured.given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    @Step("Авторизация пользователя")
    public Response loginUser(User user) {
        return RestAssured.given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/auth/login")
                .then()
                .extract()
                .response();
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String userId) {
        return RestAssured.delete("/api/auth/user/" + userId);
    }

    // Метод для парсинга токена из ответа
    public String extractAndFormatToken(Response response) {
        return "Bearer " + response.jsonPath().getString("access_token");
    }
}
