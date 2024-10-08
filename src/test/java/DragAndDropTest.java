import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void сhangeActionsTest () {
    open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-b").shouldHave(text("A"));
    }
    @Test
    void сhangeElementTest () {
        $("#column-b").dragAndDrop(to($("#column-a")));
        $("div#column-a").shouldHave(text("A"));
    }
    @AfterEach
    void afterEach(){
        Selenide.closeWebDriver();
    }

}