package aero.smart4aviation.www;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static aero.smart4aviation.www.configuration.Configuration.CONFIGURATION;

public class CommentFormClearTest extends BaseTestCase {

    private String url = CONFIGURATION.getValue("baseUrl");

    @Test
    public void shouldClearWhenRequiredFieldsAreFilled() throws Exception {
        String name = CONFIGURATION.getValue("name");
        String surname = CONFIGURATION.getValue("surname");
        String email = CONFIGURATION.getValue("email");
        String age = CONFIGURATION.getValue("age");

        SoftAssertions softAssertions = new SoftAssertions();

        CommentFormPage commentFormPage = new CommentFormPage(driver, url).open()
                .fillRequiredFields(name, surname, email, age)
                .clearForm();

        softAssertions.assertThat(commentFormPage.getName()).isEmpty();
        softAssertions.assertThat(commentFormPage.getSurname()).isEmpty();
        softAssertions.assertThat(commentFormPage.getEmail()).isEmpty();
        softAssertions.assertThat(commentFormPage.getAge()).isEmpty();
        softAssertions.assertAll();
    }
}