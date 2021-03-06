package uk.co.Waitrose.Tests;

import org.junit.jupiter.api.Test;
import uk.co.Waitrose.PageObjects.RegisterAccountPage;
import uk.co.Waitrose.PageObjects.WaitroseHomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WaitroseTests extends AbstractBaseTests {

//I have changed the phone number on row 24

    @Test
    public void signUpForAnAccount() throws InterruptedException {
        webDriver.get("https://www.waitrose.com/");
        WaitroseHomePage waitroseHomePage = new WaitroseHomePage(webDriver);
        waitroseHomePage.acceptCookies();
        RegisterAccountPage registerAccountPage = waitroseHomePage.navigateToRegisterAccountPage("Register");
        assertThat("", registerAccountPage.confirmRegisterAccount("Register"), is(("REGISTER")));
        registerAccountPage.selectTitle()
                .inputFirstName("Gemma")
                .inputLastName("Jones")
                .inputContactNumber("07755667876")
                .findAddress()
                .continueToCompleteRegistration("Continue")
                .confirmAccountAccepted("4 Murray Street");
    }
}

