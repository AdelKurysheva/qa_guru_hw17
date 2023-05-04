package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationsResult registrationsResult = new RegistrationsResult();
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            phoneNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress");


    public RegistrationPage openPage() {
        step("Открываем страницу регистрации", () -> {
            open("/automation-practice-form");
        });
        return this;
    }

    public RegistrationPage closeBanner() {
        step("Закрываем баннеры", () -> {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        step("Ввести имя пользователя", () -> {
            firstName.setValue(value);
        });
        return this;
    }

    public RegistrationPage setLastName(String value) {
        step("Ввести фамилию пользователя", () -> {
            lastName.setValue(value);
        });
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        step("Ввести адрес почты", () -> {
            userEmail.setValue(value);
        });
        return this;
    }

    public RegistrationPage setGender(String value) {
        step("Выбрать пол", () -> {
            $(byText(value)).click();
        });
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        step("Ввести номер телефона", () -> {
            phoneNumber.setValue(value);
        });
        return this;
    }

    public RegistrationPage dateBirthday(String day, String month, String year) {
        step("Выбрать дату рождения", () -> {
            dateOfBirthInput.click();
            calendarComponent.setDateBirthday(day, month, year);
        });
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        step("Выбрать предмет", () -> {
            subjectsInput.setValue(value).pressEnter();
        });
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        step("Выбрать хобби", () -> {
            hobbiesWrapper.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationPage setUploadFile(String value) {
        step("Загрузить картинку", () -> {
            uploadPicture.uploadFromClasspath("img/" + value);
        });
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        step("Ввести адрес жительства", () -> {
            currentAddress.setValue(value);
        });
        return this;
    }

    public RegistrationPage setState(String value) {
        step("Выбрать штат", () -> {
            $("#state").click();
            $(byText(value)).click();
        });
        return this;
    }

    public RegistrationPage setCity(String value) {
        step("Выбрать город", () -> {
            $("#city").click();
            $(byText(value)).click();
        });
        return this;
    }

    public RegistrationPage setClickSubmit() {
        step("Сохранить данные", () -> {
            $("#submit").click();
        });
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        step("Проверить сообщение в модальном окне", () -> {
            registrationsResult.verifyModalAppears();
        });
        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        step("Проверить соответствие данных введенным значениям", () -> {
            registrationsResult.verifyResults(key, value);
        });
        return this;
    }
}
