package aero.smart4aviation.www;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentFormPage extends BasePage {

    private String url;

    @FindBy(id = "name-contact")
    private WebElement nameInput;

    @FindBy(id = "surname-contact")
    private WebElement surnameInput;

    @FindBy(id = "email-contact")
    private WebElement emailInput;

    @FindBy(id = "age-contact")
    private WebElement ageInput;

    @FindBy(id = "phone-contact")
    private WebElement phoneInput;

    @FindBy(id = "comment-contact")
    private WebElement commentAreaText;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(@class,'clear')]")
    private WebElement clearButton;

    @FindBy(id = "success-message")
    private WebElement successMessage;

    @FindBy(id = "error-message")
    private WebElement errorMessage;

    CommentFormPage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
    }

    CommentFormPage open() {
        driver.get(url);
        waitForWebElementVisibility(nameInput);
        return this;
    }

    CommentFormPage fillRequiredFields(String name, String surname, String email, String age) {
        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        emailInput.sendKeys(email);
        ageInput.sendKeys(age);
        return this;
    }

    CommentFormPage fillAllFields(String name, String surname, String email, String age, String phone, String comment) {
        fillRequiredFields(name, surname, email, age);
        phoneInput.sendKeys(phone);
        commentAreaText.sendKeys(comment);
        return this;
    }

    CommentFormPage submitForm() {
        submitButton.click();
        return this;
    }

    CommentFormPage clearForm() {
        clearButton.click();
        return this;
    }

    String getName() {
        return nameInput.getText();
    }

    String getSurname() {
        return surnameInput.getText();
    }

    String getEmail() {
        return emailInput.getText();
    }

    String getAge() {
        return ageInput.getText();
    }

    String getErrorMessage() {
        return errorMessage.getText();
    }

    String getSuccessMessage() {
        return successMessage.getText();
    }
}
