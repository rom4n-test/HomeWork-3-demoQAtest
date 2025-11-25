package pages;

import components.DataPickerComponent;
import components.RegPageLocators;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

// объявление переменных с локаторами
public class RegistrationPage{

    // добавляем класс с датапикером
    DataPickerComponent dataPickerComponent = new DataPickerComponent();
    // добавляем класс с файлом
    File filePicture = new File("src/test/resources/Приложение.jpeg");

    // метод для открытия страницы
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    // метод для ввода имени
    public RegistrationPage setFirstName(String value) {
        (RegPageLocators.FIRST_NAME_INPUT).sendKeys(value);
        return this;
    }

    // метод для ввода фамилии
    public RegistrationPage setLastName(String value) {
        (RegPageLocators.LAST_NAME_INPUT).sendKeys(value);
        return this;
    }

    // метод для ввода электронной почты
    public RegistrationPage setUserEmail(String value) {
        (RegPageLocators.USER_EMAIL_INPUT).sendKeys(value);
        return this;
    }

    // метод для выбора гендера
    public RegistrationPage setGender(String value) {
        (RegPageLocators.GENDER_WRAPPER_RADIO).$(byText(value)).click();
        return this;
    }

    // метод для ввода номера телефона
    public RegistrationPage setUserPhoneNumber(String value) {
        (RegPageLocators.USER_PHONE_NUMBER_INPUT).sendKeys(value);
        return this;
    }

    // метод для ввода даты вручную
    public RegistrationPage setBirthDateManual(String value) {
        (RegPageLocators.BIRTH_DAY_INPUT).click();
        (RegPageLocators.BIRTH_DAY_INPUT).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        (RegPageLocators.BIRTH_DAY_INPUT).sendKeys(value);
        (RegPageLocators.BIRTH_DAY_INPUT).pressEnter();
        return this;
    }

    // метод для ввода даты через датапикер
    public RegistrationPage setBirthDate(String day, String month, String year) {
        (RegPageLocators.BIRTH_DAY_INPUT).click();
        dataPickerComponent.setDate(day, month, year);
        return this;
    }

    // метод выбора предмета
    public RegistrationPage setSubject(String value1, String value2) {
        (RegPageLocators.SUBJECT_INPUT).setValue(value1).pressEnter()
                .setValue(value2).pressEnter();
        return this;
    }

    // метод для удаления первого в списке предмета
    public RegistrationPage deleteSubject() {
        (RegPageLocators.SUBJECT_DELETE_PUSH).click();
        return this;
    }

    // метод для выбора чекбокса
    public RegistrationPage setHobbies() {
        (RegPageLocators.HOBBIES_CHECKBOX_FIRST).click();
        (RegPageLocators.HOBBIES_CHECKBOX_SECOND).click();
        (RegPageLocators.HOBBIES_CHECKBOX_THIRD).click();
        (RegPageLocators.HOBBIES_CHECKBOX_FIRST).click();
        (RegPageLocators.HOBBIES_CHECKBOX_SECOND).click();
        (RegPageLocators.HOBBIES_CHECKBOX_THIRD).click();
        (RegPageLocators.HOBBIES_CHECKBOX_SECOND).click();
        return this;
    }

    // метод для загрузки файла
    public RegistrationPage uploadFile() {
        (RegPageLocators.UPLOAD_PICTURE).uploadFile(filePicture);
        return this;
    }

    // метод для ввода адреса
    public RegistrationPage setAddress(String value) {
        (RegPageLocators.ADDRESS_INPUT).setValue(value);
        return this;
    }

    // метод для выбора штата
    public RegistrationPage setState(String value) {
        (RegPageLocators.STATE_SELECT).click();
        $(byText(value)).click();
        return this;
    }

    // метод для выбора города
    public RegistrationPage setCity(String value) {
        (RegPageLocators.CITY_SELECT).click();
        $(byText(value)).click();
        return this;
    }

    // метод для клика на субмит
    public RegistrationPage clickSubmit() {
        (RegPageLocators.SUBMIT_PUSH).click();
        return this;
    }

//    // метод для проверки значений 1
//    public RegistrationPage checkResult(String key, String value) {
//        tableResponse.$(byText(key)).parent()
//        .shouldHave(text(value));
//        return this;
//    }

    // метод для проверки значений через ассерты
    public RegistrationPage checkResult(String key, String value) {
        String result = (RegPageLocators.TABLE_RESPONSE_MODAL).text();
        assertTrue(result.contains(key + " " + value));
        return this;
    }
    // метод для клика на закрыть таблицу
    public RegistrationPage clickCloseTable() {
        (RegPageLocators.CLOSE_TABLE_PUSH).click();
        return this;
    }
    // метод для проверки отсутствия таблицы
    public RegistrationPage checkTableNotExist() {
        (RegPageLocators.TABLE_WITH_THANKS).shouldNot(exist);
        return this;
    }
    // метод для проверки открытия таблицы с благодарностью за регистрацию
    public RegistrationPage checkTableWithThanks() {
        (RegPageLocators.TABLE_WITH_THANKS).shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        return this;
    }
}