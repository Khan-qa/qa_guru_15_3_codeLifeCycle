package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class automationPracticeFormTests {

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
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(phone);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--017").click();

        $("#subjectsInput").setValue(subject).pressEnter();

        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(Condition.appear);
    }

}
