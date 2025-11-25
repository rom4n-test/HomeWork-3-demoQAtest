package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormTests {

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
    }

        @Test
        void fillFormTest() {
//открываем страницу
            Selenide.clearBrowserCookies();
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//удаляем лишние элементы со страницы которые могут мешать
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

//вводим значениия для полей First Name, Last Name, Email
            $("#firstName").setValue("Valeriy");
            $("#lastName").setValue("Samodurov");
            $("#userEmail").setValue("valeron1337@test.ru");

//проверяем рабату батонов
            $("#genterWrapper").$(byText("Other")).click();
            $("[for='gender-radio-3']").click();
            $("[for='gender-radio-2']").click();
            $("[for='gender-radio-1']").click();

//водим номер тел
            $("#userNumber").setValue("9993274687");

//вводим дату вручную и проверяем что она встала по маске
            $("#dateOfBirthInput").click();
            $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $("#dateOfBirthInput").sendKeys("01.12.2004");
            $("#dateOfBirthInput").sendKeys(Keys.ENTER);
            $("#dateOfBirthInput").shouldHave(attribute("value", "12 Jan 2004"));

//вводим дату через пикер
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOptionByValue("1990");
            $(".react-datepicker__month-select").selectOptionByValue("6");
            $(".react-datepicker__day--019").hover().click();

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

//вводим адрес
            $("#currentAddress").click();
            $("#currentAddress").setValue("Sun street 12");

//выбираем штат и город
            $("#state").click();
            $(byText("Uttar Pradesh")).click();
            $("#city").click();
            $(byText("Agra")).click();

//кликаем на субмит
            $("#submit").hover().click();

//проверяем таблицу с введёнными данными
//            $(".table-responsive").shouldHave(text("Valeriy Samodurov"));
//            $(".table-responsive").shouldHave(text("valeron1337@test.ru"));
//            $(".table-responsive").shouldHave(text("Male"));
//            $(".table-responsive").shouldHave(text("9993274687"));
//            $(".table-responsive").shouldHave(text("19 July,1990"));
//            $(".table-responsive").shouldHave(text("Computer Science"));
//            $(".table-responsive").shouldHave(text("Reading"));
//            $(".table-responsive").shouldHave(text("Приложение.jpeg"));
//            $(".table-responsive").shouldHave(text("Sun street 12"));
//            $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
            String result = $(".table-responsive").text();	//
            assertTrue(result.contains("Student Name Valeriy Samodurov"));		// проверка текста. Хорошая практика

//закрываем таблицу
            $("#closeLargeModal").click();
        }
    }