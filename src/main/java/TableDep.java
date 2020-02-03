import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableDep {
    private WebElement tableDep;
    private WebDriver driver;

    public TableDep(WebElement tableDep, WebDriver driver){
        this.tableDep = tableDep;
        this.driver = driver;
    }

    public List<WebElement> getRows(){
        List<WebElement> rows = tableDep.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

//    public List<List<WebElement>> getRowsWithColums(){
//
//    }

}
