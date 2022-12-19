package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomationPracticeFormTests {

    String firstName = "Хан";
    String lastName = "Ханов";
    String email = "han@hanov.com";
    String gender = "Female";
    String phone = "7123456789";

    String day = "17",
            month = "May",
            year = "1999";
    String subject = "Physics";
    String hobbies = "Sports";
    String picture = "1.png";

    String currentAddress = "Han KZ";

    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    void homeWorkTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(phone);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();

        $("#subjectsInput").setValue(subject).pressEnter();

        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $(".modal-dialog").should(Condition.appear);

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).parent().lastChild().shouldHave(text("Хан Ханов"));
        $(".table").$(byText("Student Email")).parent().lastChild().shouldHave(text("han@hanov.com"));
        $(".table").$(byText("Gender")).parent().lastChild().shouldHave(text("Female"));
        $(".table").$(byText("Mobile")).parent().lastChild().shouldHave(text("7123456789"));
        $(".table").$(byText("Date of Birth")).parent().lastChild().shouldHave(text("17 May,1999"));
        $(".table").$(byText("Subjects")).parent().lastChild().shouldHave(text("Physics"));
        $(".table").$(byText("Hobbies")).parent().lastChild().shouldHave(text("Sports"));
        $(".table").$(byText("Picture")).parent().lastChild().shouldHave(text("1.png"));
        $(".table").$(byText("Address")).parent().lastChild().shouldHave(text("Han KZ"));
        $(".table").$(byText("State and City")).parent().lastChild().shouldHave(text("NCR Delhi"));
    }

}
