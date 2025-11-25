package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class VerifyPage {
    private final ElementsCollection code = $$(".code");
    private final SelenideElement info = $(".info");

    public VerifyPage open() {
        Selenide.open("verify-account/");   // открываем страницу
        return this;
    }
    public VerifyPage enterCode(String value) {
            code.asFixedIterable().forEach(element -> element.setValue(value));
            return this;
    }
    public String getInfoText() {
        return info.getText();
    }
}
