import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 public class Select {


     private static WebDriver driver;

     public Select(WebDriver driver){

         this.driver = driver;
     }

    public static void selectCheckbox(String name){

        String chXpath = "//*[@class='info_area' and text()='%s']//..//input[@type='checkbox']";

        if (!driver.findElement(By.xpath(String.format(chXpath, name))).isSelected()){
            driver.findElement(By.xpath(String.format(chXpath, name))).click();}
    }
}
