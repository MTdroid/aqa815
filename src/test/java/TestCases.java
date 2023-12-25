import com.codeborne.selenide.Selenide;
import example.pages.*;
import example.steps.Asserts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestCases {
    private MainPage mainPage;
    private CityChangePage cityChangePage;
    private FiltersPage filtersPage;
    private SearchingResultsPage searchingResultsPage;
    private CartPage cartPage;

    @BeforeEach
    public void openWb() {

        Selenide.open("https://www.wildberries.ru/");
        Selenide.sleep(300);
        mainPage = new MainPage();
        cityChangePage = new CityChangePage();
        filtersPage = new FiltersPage();
        searchingResultsPage = new SearchingResultsPage();
        cartPage = new CartPage();
    }

    @Test
    @DisplayName("Тест-кейс 1: Работа с поисковой строкой")
    public void searchLine() {

        mainPage.searchFirstItem("Iphone 13");
        Asserts.searchingResultAssert();
        mainPage.clearSearchLine();
        Asserts.searchLineIsEmpty();
    }

    @DisplayName("Тест-кейс 2: Смена города")
    @Test
    public void changeTheCity() {

        mainPage.clickCityChange();
        cityChangePage.changeCity("Санкт-Петербург");

        String addressConfirm = CityChangePage.addressConfirm.getText();

        Asserts.textEquals(addressConfirm,CityChangePage.pickAddress.getText());
        cityChangePage.pickAddress();

        Asserts.textEquals(addressConfirm, mainPage.getCity());
    }

    @DisplayName("Тест-кейс 3: Добавление товара в корзину")
    @Test
    public void addToCart() {
        mainPage.clickFilters();
        filtersPage.openVacuumCleaners();

        Asserts.textEquals(searchingResultsPage.getTitle(), "Пылесосы и пароочистители");
        Asserts.textEquals(searchingResultsPage.getPagePath(), "Главная\n" +
                "Бытовая техника\n" +
                "Техника для дома\n" +
                "Пылесосы и пароочистители");

        String price = searchingResultsPage.getPrice();
        searchingResultsPage.addToCartFirstProduct();

        Asserts.textEquals(mainPage.cartCounter(),"1");
        mainPage.clickCart();

        Asserts.textEquals(searchingResultsPage.getName(),cartPage.getName());
        Asserts.textEquals(price,cartPage.getPrice());
        Asserts.textEquals(cartPage.gettotalPrice(),cartPage.getPrice());

        cartPage.orderButtonIsEnabled();
    }

    @DisplayName("Тест-кейс 4: Работа с фильтрами")
    @Test
    public void settingFilters() {

        mainPage.clickFilters();
        filtersPage.openLaptops();

        Asserts.textEquals(searchingResultsPage.getTitle(), "Ноутбуки и ультрабуки");

        searchingResultsPage.dropDownFilter("100000", "149000");

        Asserts.textEquals(searchingResultsPage.getChoiceList(),"до 3 дней\n" +
                "Apple\n" +
                "от 100 000 до 149 000\n" +
                "13.6\"\n" +
                "Сбросить все");

        searchingResultsPage.dropAllEnabled();

        Asserts.textEquals(searchingResultsPage.getTotalItems(),searchingResultsPage.getProductSizeOnPage());
    }
}