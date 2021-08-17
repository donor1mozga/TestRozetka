package Rozetka.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class PhoneTVElectronicsCategoryPage {

    private final SelenideElement phoneList = $x("//li[@class='portal-grid__cell ng-star-inserted'][1]");
    private final SelenideElement allLists = $x("//div[@class=\"ng-star-inserted\"][2]");

    @Step("Choose phone list")
    public PhonePage choosePhoneList() {
        allLists.shouldBe(Condition.visible);
        phoneList.click();
        return page(PhonePage.class);
    }
}
