
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CountObjectOnThePage {
        public static void main(String[] args) throws InterruptedException {
                System.setProperty("webdriver.chrome.driver", "/Users/KTkachev/Downloads/WebDrivers/msedgedriver.exe");
                EdgeDriver driver = new EdgeDriver();
                try {
                        driver.get("https://home.luxoft.com/");
                        Thread.sleep(10000);
                        driver.findElement(By.xpath("//*[@id=\"tilesHolder\"]/div[2]/div/div")).click();
                        Thread.sleep(5000);
                        driver.findElement(By.xpath("/html/body/app-root/app-start-screen/app-header/div/div[2]/div/app-input-search/div/app-clear-wrap/div/input")).sendKeys("BSS Core" + Keys.RETURN) ;
                        Thread.sleep(5000);

                        int showMoreClickCount = 22;
                        for (int i = 0; i < showMoreClickCount; i++) {
                                driver.findElement(By.className("show-more")).click();
                                Thread.sleep(3000);
                        }

                        int countAvatar = driver.findElements(By.className("avatar")).size();
                        System.out.println("Number of avatar on the page: " + countAvatar);
                }
                finally {
                        driver.quit();
                }
        }
}


