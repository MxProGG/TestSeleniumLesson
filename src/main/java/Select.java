import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 public class Select {

    public static void selectCheckbox(String name, WebDriver driver){

        String chXpath = "//*[@class='info_area' and text()='%s']//..//input[@type='checkbox']";

        if (!driver.findElement(By.xpath(String.format(chXpath, name))).isSelected()){
            driver.findElement(By.xpath(String.format(chXpath, name))).click();}
    }

     public static void deselectCheckbox(String name, WebDriver driver){

         String chXpath = "//*[@class='info_area' and text()='%s']//..//input[@type='checkbox']";

         if (driver.findElement(By.xpath(String.format(chXpath, name))).isSelected()){
             driver.findElement(By.xpath(String.format(chXpath, name))).click();}
     }
}
