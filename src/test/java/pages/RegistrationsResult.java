package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class RegistrationsResult {
    public void verifyModalAppears() {
        $(".modal-dialog").should(Condition.appear);
    }

    public void verifyResults(String key, String value) {
        step("Проверяем поле " + key, () -> {
            $(".table-responsive").$(byText(key)).parent()
                    .shouldHave(text(value));
        });
    }
}
