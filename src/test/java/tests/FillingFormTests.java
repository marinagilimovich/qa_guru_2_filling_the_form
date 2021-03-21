package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillingFormTests {
    String firstName = "Migde",
            lastName = "Maisel",
            userEmail = "midgeme123@gmail.com",
            userNumber = "0123456789",
            gender = "Female",
            dateOfBirth = "03",
            monthOfBirth = "May",
            yearOfBirth = "1964",
            subject = "Chemistry",
            hobby = "Music",
            picture = "1.png",
            currentAddress = "10 Main str.",
            state = "Haryana",
            city = "Karnal";

    @Test
    void FillingFieldsTests() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dateOfBirth + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + ' ' + lastName), text(userEmail), text(gender),
                text(userNumber), text(dateOfBirth + ' ' + monthOfBirth + ',' + yearOfBirth), text(subject),
                text(hobby), text(picture), text(currentAddress), text(state + " " + city));
    }
}
