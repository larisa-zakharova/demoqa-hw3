import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {

    @BeforeAll
    static void initialConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //Удаление всплывающих баннеров
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alex_ivanov@gmail.com");
        $("#genterWrapper").$(byText(("Male"))).click();
        $("#userNumber").setValue("8900234456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("October")).click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month").$(byText("24")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText(("Sports"))).click();
        $("#hobbiesWrapper").$(byText(("Music"))).click();
        $("input[type='file']").uploadFromClasspath("images/images.jfif");
        $("#currentAddress").setValue("Saint Petersburg, Nevskiy prospekt, 9");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Alex Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("alex_ivanov@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8900234456"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("24 October,2000"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English, Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("images.jfif"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Saint Petersburg, Nevskiy prospekt, 9"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}

