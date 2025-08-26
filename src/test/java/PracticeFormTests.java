import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {

    @BeforeAll
    static void initialConfig() {
        Configuration.browserSize ="1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alex_ivanov@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("8900234456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find(byText("October")).click();
        $(".react-datepicker__year-select").find(byText("2000")).click();
        $(".react-datepicker__month").find(byText("24")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("input[type='file']").uploadFromClasspath("images/images.jfif");
        $("#currentAddress").setValue("Saint Petersburg, Nevskiy prospekt, 9");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("tr", 1).shouldHave(text("Alex Ivanov"));
        $("tr", 2).shouldHave(text("alex_ivanov@gmail.com"));
        $("tr", 3).shouldHave(text("Male"));
        $("tr", 4).shouldHave(text("8900234456"));
        $("tr", 5).shouldHave(text("24 October,2000"));
        $("tr", 6).shouldHave(text("English, Computer Science"));
        $("tr", 7).shouldHave(text("Sports, Music"));
        $("tr", 8).shouldHave(text("images.jfif"));
        $("tr", 9).shouldHave(text("Saint Petersburg, Nevskiy prospekt, 9"));
        $("tr", 10).shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}

