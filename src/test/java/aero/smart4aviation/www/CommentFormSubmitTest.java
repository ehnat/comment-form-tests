package aero.smart4aviation.www;

import org.testng.annotations.Test;

import static aero.smart4aviation.www.configuration.Configuration.CONFIGURATION;
import static org.assertj.core.api.Assertions.assertThat;

public class CommentFormSubmitTest extends BaseTestCase {

    private String url = CONFIGURATION.getValue("baseUrl");

    @Test
    public void shouldSendFormWithFilledRequiredFields() throws Exception {
        String name = CONFIGURATION.getValue("name");
        String surname = CONFIGURATION.getValue("surname");
        String email = CONFIGURATION.getValue("email");
        String age = CONFIGURATION.getValue("age");

        CommentFormPage commentFormPage = new CommentFormPage(driver, url).open()
                .fillRequiredFields(name, surname, email, age)
                .submitForm();

        assertThat(commentFormPage.getSuccessMessage()).contains("comment was sent successfully");
    }

    @Test
    public void shouldSendFormWithFilledAllFields() throws Exception {
        String name = CONFIGURATION.getValue("name");
        String surname = CONFIGURATION.getValue("surname");
        String email = CONFIGURATION.getValue("email");
        String age = CONFIGURATION.getValue("age");
        String phone = CONFIGURATION.getValue("phone");
        String comment = CONFIGURATION.getValue("comment");

        CommentFormPage commentFormPage = new CommentFormPage(driver, url).open()
                .fillAllFields(name, surname, email, age, phone, comment)
                .submitForm();

        assertThat(commentFormPage.getSuccessMessage()).contains("comment was sent successfully");

    }

    @Test
    public void shouldNotSubmitEmptyForm() throws Exception {

        CommentFormPage commentFormPage = new CommentFormPage(driver, url).open()
                .submitForm();

        assertThat(commentFormPage.getErrorMessage().contains("Required fields must be filled"));
    }

    @Test
    public void shouldNotSubmitWithIncorrectAge() throws Exception {
        String name = CONFIGURATION.getValue("name");
        String surname = CONFIGURATION.getValue("surname");
        String email = CONFIGURATION.getValue("email");
        String age = CONFIGURATION.getValue("age");

        CommentFormPage commentFormPage = new CommentFormPage(driver, url).open()
                .fillRequiredFields(name, surname, email, age)
                .submitForm();

        assertThat(commentFormPage.getErrorMessage()).contains("Age is out of range");
    }
}