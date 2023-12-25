package example.pages;


import com.codeborne.selenide.SelenideElement;
import example.steps.Asserts;
import example.steps.WbSteps;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public static SelenideElement searchLine = $x("//input[@id='searchInput']");
    public static SelenideElement cityChange =$x("//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
    public static SelenideElement filters = $x("//button[@class='nav-element__burger j-menu-burger-btn j-wba-header-item']");
    public static SelenideElement cart = $x("//span[@class='navbar-pc__notify']");
    public static SelenideElement clearSearchLine = $x("//button[@class='search-catalog__btn search-catalog__btn--clear search-catalog__btn--active']");
    public static SelenideElement searchButton = $x("//button[@id='applySearchBtn']");

    public MainPage searchFirstItem(String value) {
        WbSteps.click(searchLine);
        WbSteps.sendKeys(searchLine, value);
        WbSteps.click(searchButton);

        return this;
    }
    public MainPage clearSearchLine() {
        WbSteps.click(clearSearchLine);

        return this;
    }
    public MainPage clickCityChange() {
        WbSteps.click(cityChange);

        return this;
    }
    public String getCity() {

        return cityChange.getText();
    }
    public MainPage clickFilters() {
        WbSteps.click(filters);

        return this;
    }

    public String cartCounter() {

        return cart.getText();
    }

    public MainPage clickCart() {
        WbSteps.click(cart);

        return this;
    }

}
