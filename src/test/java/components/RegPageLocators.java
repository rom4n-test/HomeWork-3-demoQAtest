package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegPageLocators {
    public static final SelenideElement
            FIRST_NAME_INPUT = $("#firstName"),
            LAST_NAME_INPUT = $("#lastName"),
            USER_EMAIL_INPUT = $("#userEmail"),
            USER_PHONE_NUMBER_INPUT = $("#userNumber"),
            GENDER_WRAPPER_RADIO = $("#genterWrapper"),
            BIRTH_DAY_INPUT = $("#dateOfBirthInput"),
            SUBJECT_INPUT = $("#subjectsInput"),
            SUBJECT_DELETE_PUSH = $(".subjects-auto-complete__multi-value__remove"),
            HOBBIES_CHECKBOX_FIRST = $("label[for='hobbies-checkbox-1']"),
            HOBBIES_CHECKBOX_SECOND = $("label[for='hobbies-checkbox-2']"),
            HOBBIES_CHECKBOX_THIRD = $("label[for='hobbies-checkbox-3']"),
            UPLOAD_PICTURE = $("#uploadPicture"),
            ADDRESS_INPUT = $("#currentAddress"),
            STATE_SELECT = $("#state"),
            CITY_SELECT = $("#city"),
            SUBMIT_PUSH = $("#submit"),
            TABLE_RESPONSE_MODAL = $(".table-responsive"),
            CLOSE_TABLE_PUSH = $("#closeLargeModal"),
            TABLE_WITH_THANKS = $(".modal-content");
}
