package pages;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
public class MainPage {

    @Step("Успешное открытие главной страницы Wikipedia")
    public void checkSuccessfulOpenMainPage() {
        $(id("org.wikipedia.alpha:id/search_container")).shouldBe(visible);

    }
}
