package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
//указываем браузер
        Configuration.browser = "chrome";
//устанавливаем разрешение страницы
        Configuration.browserSize = "1920x1080";
//без этого костыля бесконечная загрузка страницы, победить которую не удалось
        Configuration.pageLoadStrategy = "eager";
//указываем хост страницы
        Configuration.baseUrl = "https://demoqa.com";
//указываем что не хотим закрывать браузер по завершению
        Configuration.holdBrowserOpen = true;
//замедлить
        sleep(500);
        Selenide.clearBrowserCookies();
    }
}
