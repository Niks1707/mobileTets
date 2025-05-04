package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.OnboardingPage;

public class SearchTests extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка прохождения онбординга приложения")
    public void OnboardingTest() {
        String deviceHost = System.getProperty("deviceHost", "local");

        // Если deviceHost не равно "browserstack", то выполняем шаги онбординга
        if (!"browserstack".equalsIgnoreCase(deviceHost)) {
            onboardingPage.checkOnboardingStep("The Free Encyclopedia");
            onboardingPage.clickContinueButton();
            onboardingPage.checkOnboardingStep("New ways to explore");
            onboardingPage.clickContinueButton();
            onboardingPage.checkOnboardingStep("Reading lists with sync");
            onboardingPage.clickContinueButton();
            onboardingPage.checkOnboardingStep("Data & Privacy");
            onboardingPage.clickGetStartedButton();
        }
        mainPage.checkSuccessfulOpenMainPage();
    }
}
