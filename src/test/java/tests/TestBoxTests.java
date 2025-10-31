package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//Импорт методов
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
//устанавливаем разрешение страницы
        Configuration.browserSize = "1920x1080";
//без этого костыля бесконечная загрузка страницы, победить которую не удалось
        Configuration.pageLoadStrategy = "eager";
//указываем хост страницы
        Configuration.baseUrl = "https://demoqa.com";
//указываем что не хотим закрывать браузер по завершению
//        Configuration.holdBrowserOpen = true;
//устанавливаем таймаут
        Configuration.timeout = 5000; //по умолчанию 4000
    }

    @Test
    void fillFormTest() {
//открываем страницу по эндпоинту
        open("/text-box");
//вводим значениия
        $("#userName").setValue("Stas");
        $("#userEmail").setValue("stas@test.ru");
        $("#currentAddress").setValue("Stas city");
        $("#permanentAddress").setValue("Stasovo");
//кликаем на подтверждение
        $("#submit").click();

//выполняем поиск элементов
        $("#output #name").shouldHave(text("Stas"));
        $("#output #email").shouldHave(text("stas@test.ru"));
        $("#output #currentAddress").shouldHave(text("Stas city"));
        $("#output #permanentAddress").shouldHave(text("Stasovo"));

        System.out.println("Тест выполнен успешно!");
    }
}
