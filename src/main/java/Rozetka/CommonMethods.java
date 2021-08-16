package Rozetka;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class CommonMethods {


    @Step("{url} Open page")
    public static void openPage(String url) {
        Configuration.startMaximized = true;
        open(url);
        Configuration.timeout = 7000;
    }

    @AfterMethod
    private void close() {
        closeWebDriver();
    }


}
