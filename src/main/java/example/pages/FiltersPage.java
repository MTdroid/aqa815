package example.pages;

import com.codeborne.selenide.SelenideElement;
import example.steps.WbSteps;

import static com.codeborne.selenide.Selenide.$x;

public class FiltersPage {

    public static SelenideElement householdAppliances = $x("//a[contains(text(), 'Бытовая техника')]");
    public static SelenideElement homeAppliances = $x("//span[contains(text(), 'Техника для дома')]");
    public static SelenideElement vacuumSteamCleaners = $x("//span[contains(text(), 'Пылесосы и пароочистители')]");
    public static SelenideElement vacuumCleaners = $x("//a[@href=\"https://www.wildberries.ru/catalog/elektronika/tehnika-dlya-doma/pylesosy-i-parootchistiteli\"]");
    public static SelenideElement  electronics = $x("//a[contains(text(), 'Электроника')]");
    public static SelenideElement laptopsAndPc = $x("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static SelenideElement laptops = $x("//a[@class=\"menu-burger__link j-menu-drop-link\"][@href= 'https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki']");

    public FiltersPage openVacuumCleaners() {

        WbSteps.hover(householdAppliances);
        WbSteps.click(homeAppliances);
        WbSteps.click(vacuumSteamCleaners);
        WbSteps.click(vacuumCleaners);

        return this;
    }

    public FiltersPage openLaptops() {

        WbSteps.hover(electronics);
        WbSteps.click(laptopsAndPc);
        WbSteps.click(laptops);

        return this;
    }






   /* MainPageElements.filters.shouldBe(visible).click();
        FiltersElements.electronics.shouldBe(visible).hover();
        FiltersElements.laptopsAndPc.shouldBe(visible).click();
        FiltersElements.laptops.shouldBe(visible).click();

        WbSteps.textEquals(SearchingResultsElements.title.getText(), "Ноутбуки и ультрабуки");

        SearchingResultsElements.dropDownFilterButton.shouldBe(visible).click();

        SearchingResultsElements.startPrice.shouldBe(interactable).clear();
        SearchingResultsElements.startPrice.shouldBe(interactable).sendKeys("100000");
        SearchingResultsElements.endPrice.shouldBe(interactable).clear();
        SearchingResultsElements.endPrice.shouldBe(interactable).sendKeys("149000");
        SearchingResultsElements.upTo3Days.shouldBe(interactable).click();
        SearchingResultsElements.apple.shouldBe(interactable).click();
        SearchingResultsElements.size.shouldBe(visible).click();
        SearchingResultsElements.showAll.shouldBe(interactable).click();

        WbSteps.textEquals(SearchingResultsElements.choiseList.shouldBe(visible).getText(),
                "до 3 дней\n" +
                        "Apple\n" +
                        "от 100 000 до 149 000\n" +
                        "13.6\"\n" +
                        "Сбросить все");
        SearchingResultsElements.dropAll.shouldBe(enabled);

        WbSteps.textEquals(SearchingResultsElements.totalItems.getText(), String.valueOf(SearchingResultsElements.checkSize.size()));*/
}
