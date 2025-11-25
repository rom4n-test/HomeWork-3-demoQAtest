package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DataPickerComponent {
    public void setDate(String day, String month, String year) {
            $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOption(month);
        $$("div.react-datepicker__day").findBy(text(day)).click();
    }
}
