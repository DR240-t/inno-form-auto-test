import Driver.DriverManager;
import Page.ContactUsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTest {
    private WebDriver driver;
    private ContactUsPage page;

    @BeforeEach
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.get("https://innowise.com/contact-us/");
        page = new ContactUsPage(driver);
    }

    @AfterEach
    public void tearDown(){
        DriverManager.quitDriver();
    }

    @Test
    @DisplayName("Validation check: empty name")
    public void emptyName(){
        page.fillCompany("vscvschs");
        page.fillEmail("vscvschs@example.com");
        page.fillPhone("+49655932");
        page.fillDescription("awesrdtfcyvgbhcfxrdcfghv");
        page.selectBudget("$15K-$30K");

        page.clickSend();

        assertTrue(page.isNameErrorDisplayed(),
                "Error message should be displayed when Name field is empty");
    }

    @Test
    @DisplayName("Validation check: email without '@'")
            public void emailWithoutSnaill(){
        page.fillName("Jon");
        page.fillEmail("email.com");
        page.fillPhone("+53156523");
        page.fillDescription("Description");
        page.selectBudget("$100K-$250K");

        page.clickSend();

        assertTrue(page.isEmailErrorDisplayed(),
                "Error message should be displayed when Email field haven't '@'");
    }

    @Test
    @DisplayName("Validation check: email without domain")
    public void emailWithoutDomain(){
        page.fillName("Jon");
        page.fillEmail("email@");
        page.fillPhone("+531565230");
        page.fillDescription("Description");
        page.selectBudget("$100K-$250K");

        page.clickSend();

        assertTrue(page.isEmailErrorDisplayed(),
                "Error message should be displayed when Email field haven't domain part");
    }

    @Test
    @DisplayName("Validation check: email without name")
    public void emailWithoutName(){
        page.fillName("Noell");
        page.fillEmail("@example.com");
        page.fillPhone("+123456789");
        page.fillDescription("Description");
        page.selectBudget("More than $500K");

        page.clickSend();

        assertTrue(page.isEmailErrorDisplayed(),
                "Error message should be displayed when Email field haven't name part");
    }

    @Test
    @DisplayName("Validation check: phone with letters")
    public void phoneWithLetters(){
        page.fillName("Natalia");
        page.fillEmail("name@example.com");
        page.fillPhone("+fghdujis");
        page.fillDescription("Description");
        page.selectBudget("More than $500K");

        page.clickSend();

        assertTrue(page.isPhoneErrorDisplayed(),
                "Error message should be displayed when Phone field made up of letters");
    }

    @Test
    @DisplayName("Validation check: phone is too long")
    public void phoneIsLong(){
        page.fillName("Natalia");
        page.fillEmail("name@example.com");
        page.fillPhone("64568785665645687856656456878566564568785665645687856656456878566564568785665645687856656456878566564568785665");
        page.fillDescription("Description");
        page.selectBudget("Under $15K");

        page.clickSend();

        assertTrue(page.isPhoneErrorDisplayed(),
                "Error message should be displayed when Phone field is too long");
    }
}
