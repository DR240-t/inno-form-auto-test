package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    private final By contuctUs = By.xpath("//h1[text()='Contact us']");

    private final By nameInput = By.id("contact-name");
    private final By companyInput = By.id("contact-company");
    private final By emailInput = By.id("contact-email");
    private final By phoneInput = By.id("contact-phone");
    private final By descriptionInput = By.id("contact-message");

    private final By budgetDropdown = By.cssSelector(".new-select");

    private final By sendButton = By.id("contact-send-button");

    private final By nameError = By.cssSelector(".name .wpcf7-not-valid-tip");
    private final By companyError = By.cssSelector(".company .wpcf7-not-valid-tip");
    private final By emailError = By.cssSelector(".email .wpcf7-not-valid-tip");
    private final By phoneError = By.cssSelector(".phone .wpcf7-not-valid-tip");
    private final By descriptionError = By.cssSelector(".message .wpcf7-not-valid-tip");

    private final By acceptCookiesButton = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    public ContactUsPage fillName(String name) {
        type(nameInput, name);
        return this;
    }

    public ContactUsPage fillCompany(String company) {
        type(companyInput, company);
        return this;
    }

    public ContactUsPage fillEmail(String email) {
        type(emailInput, email);
        return this;
    }

    public ContactUsPage fillPhone(String phone) {
        type(phoneInput, phone);
        return this;
    }

    public ContactUsPage fillDescription(String description) {
        type(descriptionInput, description);
        return this;
    }

    public ContactUsPage selectBudget(String budgetValue) {
        scrollToElement(budgetDropdown);
        clickViaJS(budgetDropdown);
        clickViaJS(By.cssSelector(".new-select__item[data-value='" + budgetValue + "']"));
        return this;
    }

    public void clickSend(){
        scrollToElement(sendButton);
        clickViaJS(sendButton);
    }

    public void scrollToContuctUs(){
    scrollToElement(contuctUs);
    }

    public boolean isNameErrorDisplayed() {
        return isDisplayed(nameError);
    }

    public boolean isCompanyErrorDisplayed() {
        return isDisplayed(companyError);
    }

    public boolean isEmailErrorDisplayed() {
        return isDisplayed(emailError);
    }

    public boolean isPhoneErrorDisplayed(){
        return isDisplayed(phoneError);
    }

    public boolean isDescriptionErrorDisplayed() {
        return isDisplayed(descriptionError);
    }

    public ContactUsPage acceptCookiesIfPresent() {
        try {
            if (isDisplayed(acceptCookiesButton)) {
                clickViaJS(acceptCookiesButton);
            }
        } catch (Exception e) {}
        return this;
    }

}
