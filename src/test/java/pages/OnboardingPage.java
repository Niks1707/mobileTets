package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static com.codeborne.selenide.Condition.text;

public class OnboardingPage {
    @Step("Проверка текста шага онбординга")
    public OnboardingPage checkOnboardingStep(String expectedText) {
        $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text(expectedText));
        return this;
    }

    @Step("Нажатие кнопки 'Continue' на экране онбординга")
    public OnboardingPage clickContinueButton() {
        $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        return this;
    }

    @Step("Нажатие кнопки 'Get Started' на экране онбординга")
    public OnboardingPage clickGetStartedButton() {
        $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        return this;
    }

}
