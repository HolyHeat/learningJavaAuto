package pages;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.LoginPage;
import pageObjects.CreateAccountPage;

public class AuthPage extends BasePage {

    // Constructor
    public AuthPage (WebDriver driver) {super (driver);}

    //Web Elements
    WebElement usernameLocator = LoginPage.userName(driver);
    WebElement passwordLocator = LoginPage.password(driver);
    WebElement loginButtonLocator = LoginPage.submit(driver);
    WebElement welcomeMessageLocator = LoginPage.message(driver);
    WebElement createAccountLinkLocator = LoginPage.createAccountLink(driver);
    WebElement createAccountHeaderLocator = CreateAccountPage.header(driver);


    //Page methods

    public AuthPage authenticate (String username, String password){
        //Enter Username
        writeText(usernameLocator,username);
        //Enter password
        writeText(passwordLocator,password);
        //Click login button
        click(loginButtonLocator);
        return this;
    }
    //verify username condition
    public AuthPage verifyLogin (String expectedText) {
        assertEquals(welcomeMessageLocator,expectedText);
        return this;
    }
    //verify username condition
    public AuthPage clickCreateAccount() {
        //Click login button
        click(createAccountLinkLocator);
        return this;
    }
    //verify Create Account Page Condition
    public AuthPage verifySignupPage (String expectedText) {
        assertEquals(createAccountHeaderLocator,expectedText);
        return this;
    }
}
