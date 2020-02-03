
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class Home {

    public static void HomeTest() {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "H:\\Projects\\TestSeleniumLesson\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Чтоб окно браузера запускалось на втором мониторе
        driver.manage().window().setPosition(new Point(1930, 60));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1600,1000));

        driver.get("https://www.w3schools.com/html/html_tables.asp");

        WebElement tableElement = driver.findElement(By.xpath("//table[@id='customers']"));

        HomeTable table = new HomeTable(tableElement,driver);
        System.out.println("Rows is " + table.getRows().size());
        System.out.println(table.getValueFromCell(2,3));
        System.out.println(table.getValueFromCell(4, "Company"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("alert('Hello Word!');");
        try{
        Thread.sleep(3000);}
        catch (Exception e){e.printStackTrace();}
        driver.switchTo().alert().accept();



    }
}
