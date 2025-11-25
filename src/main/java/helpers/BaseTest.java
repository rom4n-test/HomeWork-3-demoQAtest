package helpers;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.sleep;

public class BaseTest {
    @BeforeAll

    static void setup() {
//указываем браузер
        Configuration.browser = "chrome";
//устанавливаем разрешение страницы
        Configuration.browserSize = "1920x1080";
//без этого костыля бесконечная загрузка страницы, победить которую не удалось
        Configuration.pageLoadStrategy = "eager";
//указываем хост страницы
        Configuration.baseUrl = "https://qaplayground.dev/apps";
//указываем что не хотим закрывать браузер по завершению
        Configuration.holdBrowserOpen = true;
//замедлить
//       sleep(500);
    }
}
