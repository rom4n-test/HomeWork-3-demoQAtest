package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void solntsevShouldBeTop(){
        // открыть страницу репозитория
        open("https://github.com/selenide/selenide");
        // навести мышку на первого человека
   //     $(".BorderGrid").$(byText("Contributors"))
                $$("[class='mb-2 mr-2']").first().hover();
        //найти его имя и фамилию
        $("div section span a").shouldHave(text("Andrei Solntsev"));
        sleep(5000);
    }
}
