package Rozetka.pages;


import com.codeborne.selenide.Condition;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement phoneTVElectronicsCategory = $x("//ul[@class='menu-categories menu-categories_type_main']/li[2]");


    @Step("Choose category")
    public PhoneTVElectronicsCategoryPage choosePhoneTVElectronicsCategory() {
        phoneTVElectronicsCategory.shouldBe(Condition.appear).click();
        return page(PhoneTVElectronicsCategoryPage.class);
    }


}
