
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import pages.AuthPage;

@Test
public class LoginTests {
    public String baseURL = "http://localhost:8000/";
    public ChromeDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/KTkachev/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @Test()
    public void testLoginSucced () throws InterruptedException {
        //Happy path test - login succeeds
        AuthPage authPage = new AuthPage(driver);
        String expectedMessage = "Welcome back,\n" + "registeredUser";
        //Perform actions

        authPage.authenticate("registeredUser","1234").verifyLogin(expectedMessage);
        Thread.sleep(5000);
//       String message = LoginPage.message(driver).getText();
//       System.out.println(message);
//       Assert.assertEquals(message, expectedMessage);
//       LoginPage.userName(driver).sendKeys("registeredUser");
//       LoginPage.password(driver).sendKeys("1234");
//       LoginPage.submit(driver).click();
    }

     @Test()
     public void testLoginFail () throws InterruptedException {
//        driver.get("http://localhost:8000/");
         AuthPage authPage = new AuthPage(driver);
         //Perform actions
         String expectedMessage = "Account not found. Please sign up by clicking the link below";
         String expectedHeader = "Create an Account";
         authPage.authenticate("otherUser","qwerty1234")
                 .verifyLogin(expectedMessage)
                 .clickCreateAccount()
                 .verifySignupPage(expectedHeader);
/*         LoginPage.userName(driver).sendKeys("otherUser");
         LoginPage.password(driver).sendKeys("qwerty1234");
         LoginPage.submit(driver).click();
         Thread.sleep(5000);
         String message = LoginPage.message(driver).getText();
         System.out.println(message);

         Assert.assertEquals(message, expectedMessage);

         //Create account
         LoginPage.createAccountLink(driver).click();
         Thread.sleep(5000);
         String header = CreateAccountPage.header(driver).getText();

         Assert.assertEquals(header, expectedHeader);
         System.out.println(header);*/
     }
     @AfterTest
     public void endSession(){driver.quit();}
}
