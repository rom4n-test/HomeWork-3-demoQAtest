package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        //открыть главную страницу
        open("https://github.com");
        //ввести в поле поиска selenide и нажать enter
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        //кликнуть на первый репозиторий из списка найденных
        $$("[class='Box-sc-62in7e-0 fcarRM']").first().$("a").click();
        //проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide" + "/" + "selenide"));
        sleep(5000);

    }
}
