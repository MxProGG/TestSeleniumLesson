import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver", "D:\\java_project\\java_lesson_selenium\\drives\\chromedriver.exe");

       WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //Чтоб окно браузера запускалось на втором мониторе
       driver.manage().window().setPosition(new Point(1930,60));
       driver.manage().window().maximize();
       //driver.manage().window().setSize(new Dimension(1600,1000));

       driver.get("http://192.168.7.54/mis/test2/");
//       driver.navigate().to("http://192.168.7.54/test/");
//       driver.navigate().back();
//       driver.navigate().forward();
//       driver.navigate().refresh();

       System.out.println(driver.getTitle());
       System.out.println(driver.getCurrentUrl());

        //WebElement link = driver.findElement(By.linkText("ссылка"));
        //System.out.println(link);
        //WebElement link2 = driver.findElement(By.partialLinkText("Часть ссылки"));
        WebElement name = driver.findElement(By.name("Login"));
        System.out.println(name);
       driver.quit();


    }

}
