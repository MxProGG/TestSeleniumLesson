import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class MainClass {
   static WebDriver driver;
   static WebDriverWait wait;
    public static void main(String[] args) {

        //Home.HomeTest();

       System.setProperty("webdriver.chrome.driver", "D:\\java_project\\java_lesson_selenium\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //Чтоб окно браузера запускалось на втором мониторе
       driver.manage().window().setPosition(new Point(1930,60));
       driver.manage().window().maximize();
       //driver.manage().window().setSize(new Dimension(1600,1000));

       driver.get("http://192.168.7.54/mis/test2/");

        wait =(new WebDriverWait(driver, 5));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='main-title' and text()='Вход в систему']")));

//       driver.navigate().to("http://192.168.7.54/test/");
//       driver.navigate().back();
//       driver.navigate().forward();
//       driver.navigate().refresh();

       System.out.println(driver.getTitle());
       System.out.println(driver.getCurrentUrl());

//        WebElement link = driver.findElement(By.linkText("текст в ссылке"));
//        System.out.println(link);
//        WebElement linkPartial = driver.findElement(By.partialLinkText("Часть текста в ссылке"));
//        WebElement name = driver.findElement(By.name("Login"));
//        System.out.println(name);
//        WebElement className = driver.findElement(By.className("help"));
//        System.out.println(className);
//        WebElement id = driver.findElement(By.id("loginBtn"));
//        System.out.println(id);
//        WebElement tag = driver.findElement(By.tagName("head"));
//        System.out.println(tag);
//        WebElement elementcss = driver.findElement(By.cssSelector("input#Remember"));
//        System.out.println(elementcss);
//        WebElement elementXpath = driver.findElement(By.xpath("//div//img[@class='main-logo-img']"));
//        System.out.println(elementXpath);

        WebElement logoName = driver.findElement(By.xpath("//div[@class='main-login-main']//div[3]"));

        System.out.println("_____________________");
        if (logoName.getText().equals("TrustMed")){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAIL!");
        }
        System.out.println("_____________________");

        System.out.println("logoName is " + logoName.getText());

        WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("11");
        driver.findElement(By.xpath("//input[@id='loginBtn']")).click();

        WebElement linkShedule = driver.findElement(By.xpath("//div[@id='Portlet_2']//a[@href='/mis/test2/Schedule']"));
        System.out.println("link is " + linkShedule.getText());
        linkShedule.click();

        driver.findElement(By.xpath("//a[@id='search_type_all-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='search_type_all-menu']//li[4]/a")));

        driver.findElement(By.xpath("//ul[@id='search_type_all-menu']//li[4]/a")).click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@id='search_type_all-menu']//li[4]/a")));

        driver.findElement(By.xpath("//button[@id='btncanceldepgrid1']//*[@class='ui-button-text']")).click();
        WebElement tableDep = driver.findElement(By.xpath("//*[@id=\"depgrid1\"]"));

        WebElement searchDoc = driver.findElement(By.xpath("//input[@id='sinpdocprvdgrid1']"));
        searchDoc.sendKeys("TestDoc");
        System.out.println("searchDoc is " + searchDoc.getAttribute("value"));
        searchDoc.clear();

        driver.findElement(By.xpath("//a[@class='settBtn']/span[1]")).click();

        Select.selectCheckbox("Запрещено видеть данные других подразделений", driver);

        selectCheckbox("Автоматическая печать");
        Select.deselectCheckbox("Автоматическая печать", driver);
        selectCheckbox("Проверка полисов других регионов по РЗ");

      //driver.quit();



    }

    public static void selectCheckbox(String name){

        String chXpath = "//*[@class='info_area' and text()='%s']//..//input[@type='checkbox']";

        if (!driver.findElement(By.xpath(String.format(chXpath, name))).isSelected()){
            driver.findElement(By.xpath(String.format(chXpath, name))).click();}
    }

    public static void deselectCheckbox(String name){

        String chXpath = "//*[@class='info_area' and text()='%s']//..//input[@type='checkbox']";

        if (driver.findElement(By.xpath(String.format(chXpath, name))).isSelected()){
            driver.findElement(By.xpath(String.format(chXpath, name))).click();}
    }
}
