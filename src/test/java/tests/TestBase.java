package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        String deviceHost = System.getProperty("deviceHost");
        if(deviceHost.equals("real") || deviceHost.equals("emulator")){
            Configuration.browser = LocalDriver.class.getName();
        } else if(deviceHost.equals("browserstack")){
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        if (System.getProperty("deviceHost").equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            Attach.addVideo(sessionId);
        }
        if (System.getProperty("deviceHost").equals("emulation")) {
            Attach.screenshotAs("Last screenshot");
        }
        Attach.pageSource();
        closeWebDriver();
       
    }
}
