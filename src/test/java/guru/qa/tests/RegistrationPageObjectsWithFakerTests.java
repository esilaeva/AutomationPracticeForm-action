package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.RegistrationPage;
import guru.qa.pages.TestBase;
import guru.qa.pages.components.TableResultComponent;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static guru.qa.utils.Testdata.*;

public class RegistrationPageObjectsWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TableResultComponent tableResultComponent = new TableResultComponent();

    @Test
    void successRegistrationFullTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setMobileNumber(userNumber)
                .setBirthDate(birthDay, birthdayMonth, birthdayYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(fileName)
                .setAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        tableResultComponent
                .checkResult(firstName + " " + lastName)
                .checkResult(userEmail)
                .checkResult(userGender)
                .checkResult(userNumber)
                .checkResult(birthDay + " " + birthdayMonth + "," + birthdayYear)
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(fileName)
                .checkResult(streetAddress)
                .checkResult(state + " " + city);
    }
}
