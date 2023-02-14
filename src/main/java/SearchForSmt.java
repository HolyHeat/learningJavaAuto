import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class SearchForSmt {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromedriver", "/Users/KTkachev/Downloads/WebDrivers/chromedriver.exe");
        String baseURL = "https://www.google.com/";
        ChromeDriver driver = new ChromeDriver();
        int sleep3 = 3000;
        int sleep5 = 5000;
        int sleep15 = 15000;

        try {
            driver.get(baseURL);
            driver.findElement(By.className("gLFyf")).sendKeys("tehnomanija"+ Keys.RETURN);
            Thread.sleep(sleep3);
            driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]//div[1]/a/h3")).click();
            Thread.sleep(sleep3);
            driver.findElement(By.xpath("/html/body/app-root/cx-storefront/header/cx-page-layout[1]/cx-page-slot[1]/lib-cookies-consent//div/button[2]")).click();
            Thread.sleep(sleep3);
            driver.findElement(By.id("permanentData")).click();
            driver.findElement(By.id("statisticData")).click();
            driver.findElement(By.id("marketingData")).click();

        }
        finally {
            //driver.quit();
        }
    }


}
