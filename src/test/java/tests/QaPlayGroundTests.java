package tests;

import helpers.BaseTest;
import org.junit.jupiter.api.Test;
import pages.VerifyPage;;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QaPlayGroundTests extends BaseTest {

    @Test
    void verifyAccount() {
        VerifyPage verifyPage = new VerifyPage();

        verifyPage.open();
        verifyPage.enterCode("9");
        String infoText = verifyPage.getInfoText();

        assertEquals("Success!", infoText);
    }
    @Test
    void multiLevelDropdawn() {
        // Arrange
        open("multi-level-dropdown/");
        // Act
        $$("[href='#home']").last().click();
        $("[href='#settings']").click();
        // Assert
        String result = $$(".menu-item").texts().toString();	//сохраняем
        assertTrue(result.contains("JavaScript"));		// проверка текста. Хорошая практика
//        $$(".menu-item")
//        sleep(500);
    }
}
