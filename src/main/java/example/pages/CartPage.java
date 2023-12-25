package example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    public static SelenideElement price = $x("//div[@class='list-item__price-new'][1]");
    public static SelenideElement name = $x("//span[@class=\"good-info__good-name\"]");
    public static SelenideElement totalPrice = $x("//span[@data-link=\"{formatMoneyAnim (totalPriceWithCouponPersDiscAndDeliveryPrice - (!postpay() && payByBalance < 0 ? payByBalance : 0)) + totalPaymentFeeAmount converter='basketPriceWithCurrencyV2'}\"]");
    public static SelenideElement orderButton = $x("//button[@type=\"button\"][@data-link='{on submitOrder ~tag}']");

    public String getName() {

        return name.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public String gettotalPrice() {

        return totalPrice.getText();
    }

    public CartPage orderButtonIsEnabled() {
        orderButton.shouldBe(interactable);

        return this;
    }
}
