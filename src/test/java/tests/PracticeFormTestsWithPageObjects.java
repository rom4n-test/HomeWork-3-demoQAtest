package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTestsWithPageObjects extends TestBase { //при экстенде мы наследуем код в указанном классе

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
        //Проверка регистрации студента с полным набором данных
    void fillFormTestFull() {
//открываем страницу
        registrationPage.openPage()
//вводим значения для полей First Name, Last Name, Email
                .setFirstName("Valeriy")
                .setLastName("Samodurov")
                .setUserEmail("valeron1337@test.ru")
//проверяем рабату батонов
                .setGender("Other")
                .setGender("Female")
                .setGender("Male")
//водим номер тел
                .setUserPhoneNumber("9993274687")
//вводим дату вручную и проверяем что она встала по маске
                .setBirthDateManual("12.01.2004")
                //  $("#dateOfBirthInput").shouldHave(attribute("value", "12 Jan 2004"));
//вводим дату через пикер
                .setBirthDate("19", "July", "1990")
//вводим два предмета и удаляем первый
                .setSubject("History", "Math")
                .deleteSubject()
//проверяем чек-боксы
                .setHobbies()
//Загрузка файла
                .uploadFile()
//вводим адрес
                .setAddress("Sun street 12")
//выбираем штат и город
                .setState("Uttar Pradesh")
                .setCity("Agra")
//кликаем на субмит
                .clickSubmit()
// проверяем что открылась окно с благодарностью за регистрацию
                .checkTableWithThanks()
//проверяем таблицу с введёнными данными
                .checkResult("Student Name", "Valeriy Samodurov")
                .checkResult("Student Email", "valeron1337@test.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9993274687")
                .checkResult("Date of Birth", "19 July,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "Приложение.jpeg")
                .checkResult("Address", "Sun street 12")
                .checkResult("State and City", "Uttar Pradesh Agra")
//закрываем таблицу
                .clickCloseTable();
    }


    @Test  // Проверка регистрации студента с полным набором данных

    void fillFormTestMinimal() {
//открываем страницу
        registrationPage.openPage()
//вводим значения для полей First Name, Last Name, Email
                .setFirstName("Stanislav")
                .setLastName("Vasiliev")
//проверяем рабату батонов
                .setGender("Male")
//водим номер тел
                .setUserPhoneNumber("9993274687")
//кликаем на субмит
                .clickSubmit()
// проверяем что открылась окно с благодарностью за регистрацию
                .checkTableWithThanks()
//проверяем таблицу с введёнными данными
                .checkResult("Student Name", "Stanislav Vasiliev")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9993274687")
//закрываем таблицу
                .clickCloseTable();
    }


    @Test // Негативная проверка

    void fillFormTestNotInfo() {
//открываем страницу
        registrationPage.openPage()
                .setFirstName("Stanislav")
                .setLastName("Vasiliev")
//кликаем на субмит
                .clickSubmit()
                .checkTableNotExist();
    }
}