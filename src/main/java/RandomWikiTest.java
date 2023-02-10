import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;


public class RandomWikiTest {
    public static void main (String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "/Users/KTkachev/Downloads/chromedriver.exe" );
        ChromeDriver driver = new ChromeDriver();

        //visit wikipedia homepage
        driver.get("https://en.wikipedia.org");

        //find random article
        driver.findElement(By.cssSelector("#n-randompage")).click();
        Thread.sleep(5000);
        //print random article title
        System.out.println(driver.getTitle());

        //Print first heading
        String firstHeading = driver.findElement(By.cssSelector(".firstHeading")).getText();
        System.out.println(firstHeading);

        //View page info
        driver.findElement(By.linkText("Page information")).click();
        Thread.sleep(5000);

        //New search
        driver.findElement(By.name("search")).sendKeys("Selenium (software)" + Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/div[2]/ul/li[1]/table/tbody/tr/td[2]/div[1]/a")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(7000);

        //Xpath logo click
        String xpath = "/html/body/div[4]/div[2]/div/a" ;
        driver.findElement(By.xpath(xpath)).click();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);

        driver.quit();
    }
}
