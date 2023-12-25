package example.steps;

import example.pages.MainPage;
import example.pages.SearchingResultsPage;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Asserts {

    public static void searchingResultAssert() {
        assertEquals(SearchingResultsPage.title.getText(), "Iphone 13");
        assertEquals(SearchingResultsPage.burgerFilter.getText(), "Iphone 13");
        assertEquals(SearchingResultsPage.sortFilter.getText(), "По популярности");
        assertEquals(SearchingResultsPage.brand.getText(), "Apple");
    }
    public static void searchLineIsEmpty() {
        assertTrue(MainPage.searchLine.getText().isEmpty());
    }

    public static void textEquals(String element, String text) {

        Assertions.assertEquals(element,text);
    }
}
