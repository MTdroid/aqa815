package example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import example.steps.WbSteps;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchingResultsPage {

    public static SelenideElement title = $x("//h1");
    public static SelenideElement pagePath = $x("//ul[@class='breadcrumbs__list']");
    public static SelenideElement burgerFilter = $x("//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']");
    public static SelenideElement sortFilter = $x("//button[@class='dropdown-filter__btn dropdown-filter__btn--sorter']");
    public static SelenideElement brand = $x("//article[@data-nm-id][1]//span[@class='product-card__brand']");
    public static SelenideElement firstProduct = $x("//article[@data-nm-id][1]//div[@class='product-card__wrapper']");
    public static SelenideElement firstProductPrice = $x("//article[@data-nm-id][1]//ins[@class='price__lower-price'][1]");
    public static SelenideElement firstProductName = $x("//span[@class='good-info__good-name']");
    public static SelenideElement firstProductAddToCart = $x("//article[@data-nm-id][1]//a[contains(@data-link, '/lk/basket')]");
    public static SelenideElement dropDownFilterButton = $x("//button[@class=\"dropdown-filter__btn dropdown-filter__btn--all\"]");
    public static SelenideElement startPrice = $x("//input[@class=\"j-price\"][@name='startN']");
    public static SelenideElement endPrice = $x("//input[@class=\"j-price\"][@name='endN']");
    public static SelenideElement upTo3Days = $x("//span[contains(text(), 'до 3 дней')]");
    public static SelenideElement apple = $x("//span[contains(text(), 'Apple')]");
    public static SelenideElement size = $x("//span[contains(text(), '13.6')]");
    public static SelenideElement showAll = $x("//button[@class='filters-desktop__btn-main btn-main']");
    public static SelenideElement dropAll = $x("//button[contains(text(), 'Сбросить все')]");
    public static ElementsCollection checkSize = $$x("//div[@class='product-card__wrapper']");
    public static SelenideElement totalItems = $x("//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    public static SelenideElement choiseList = $x("//ul[@class=\"your-choice__list\"]");

    public String getTitle() {

        return title.getText();
    }

    public String getPagePath() {

        return pagePath.getText();
    }

    public String getPrice() {

        return firstProductPrice.getText();
    }

    public String getName() {

        return firstProductName.getText();
    }

    public SearchingResultsPage addToCartFirstProduct() {

        WbSteps.hover(firstProduct);
        WbSteps.click(firstProductAddToCart);

        return this;
    }

    public SearchingResultsPage dropDownFilter(String sPrice, String ePrice) {

        WbSteps.click(dropDownFilterButton);
        WbSteps.clear(startPrice);
        WbSteps.sendKeys(startPrice,sPrice);
        WbSteps.clear(endPrice);
        WbSteps.sendKeys(endPrice,ePrice);
        WbSteps.click(upTo3Days);
        WbSteps.click(apple);
        WbSteps.click(size);
        WbSteps.click(showAll);

        return this;
    }

    public String getChoiceList() {

        return choiseList.getText();
    }

    public SearchingResultsPage dropAllEnabled() {

        dropAll.shouldBe(enabled);

        return this;
    }

    public String getProductSizeOnPage() {

        return String.valueOf(checkSize.size());
    }

    public String getTotalItems() {

        return totalItems.getText();
    }
}
