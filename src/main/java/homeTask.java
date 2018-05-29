import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homeTask {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement passw = driver.findElement(By.id("passwd"));
        passw.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement log_in = driver.findElement(By.name("submitLogin"));
        log_in.submit();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Page URL is:" + driver.getCurrentUrl());
        System.out.println("Page title is:" + driver.getTitle());

        By locator = By.tagName("li");
        List<WebElement> check = driver.findElements(locator);
        System.out.println(check.size());
        By secondLocator = By.tagName("section");
        List<WebElement> modules = driver.findElements(secondLocator);
        System.out.println(modules.size());

        WebElement user = driver.findElement(By.id("employee_infos")); user.click();
        WebElement logout = driver.findElement(By.id("header_logout")); logout.click();

    }



    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
