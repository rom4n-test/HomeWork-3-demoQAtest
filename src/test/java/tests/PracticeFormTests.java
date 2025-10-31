package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
//устанавливаем разрешение страницы
        Configuration.browserSize = "1920x1080";
//без этого костыля бесконечная загрузка страницы, победить которую не удалось
        Configuration.pageLoadStrategy = "eager";
//указываем хост страницы
        Configuration.baseUrl = "https://demoqa.com";
//указываем что не хотим закрывать браузер по завершению
        Configuration.holdBrowserOpen = true;
    }

        @Test
        void fillFormTest() {
//открываем страницу
            open("/automation-practice-form");
//вводим значениия для полей First Name, Last Name, Email
            $("#firstName").setValue("Valeriy");
            $("#lastName").setValue("Samodurov");
            $("#userEmail").setValue("valeron1337@test.ru");
//проверяем рабату батонов
            $("[for='gender-radio-3']").click();
            $("[for='gender-radio-2']").click();
            $("[for='gender-radio-1']").click();
//водим номер тел
            $("#userNumber").setValue("9993274687");

//вводим дату вручную и проверяем        ЭКСПЕРИМЕНТ НЕ УДАЛСЯ((
//            $("#dateOfBirthInput").click();
//            $("#dateOfBirthInput").click();
//            $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            $("#dateOfBirthInput").setValue("01.12.2004");

//вводим дату через пикер
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOptionByValue("1990");
            $(".react-datepicker__month-select").selectOptionByValue("6");
            $(".react-datepicker__day--019").click();

//вводим два предмета и удаляем первый
            $("#subjectsContainer").click();
            $("#subjectsInput").setValue("history");
            $(".subjects-auto-complete__menu").click();
            $("#subjectsInput").setValue("p");
            $(".subjects-auto-complete__menu").click();
            $(".css-19bqh2r").click();

//проверяем чекбоксы
            $("[for='hobbies-checkbox-1']").click();
            $("[for='hobbies-checkbox-2']").click();
            $("[for='hobbies-checkbox-3']").click();
            $("[for='hobbies-checkbox-1']").click();
            $("[for='hobbies-checkbox-2']").click();
            $("[for='hobbies-checkbox-3']").click();
            $("[for='hobbies-checkbox-2']").click();

//Загрузка файла
            File picture = new File("src/test/resources/Приложение.jpeg");
            $("#uploadPicture").uploadFile(picture);

//
            $("#currentAddress").click();
            $("#currentAddress").setValue("Sun street 12");
        }
    }