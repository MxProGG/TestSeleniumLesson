import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class HomeTable {

    private WebElement tableElemnt;
    private WebDriver driver;

    public HomeTable(WebElement tableElemnt, WebDriver driver){
        this.tableElemnt = tableElemnt;
        this.driver = driver;
    }

    public List<WebElement> getRows(){
        List<WebElement> rows = tableElemnt.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    public List<WebElement> getHeadings(){
        WebElement headingsRow = tableElemnt.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headingColums = headingsRow.findElements(By.xpath(".//th"));
        return headingColums;
    }


    public List<List<WebElement>> getRowsWithColums(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColums = new ArrayList<List<WebElement>>();
        for (WebElement row : rows){
            List<WebElement> rowWithColums = row.findElements(By.xpath(".//td"));
            rowsWithColums.add(rowWithColums);
            }
        return rowsWithColums;
    }

    public List<Map<String, WebElement>> getRowsWithColumsByHeadings(){

        List<List<WebElement>> rowsWithColums = getRowsWithColums();
        List<Map<String, WebElement>> rowsWithColumsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingsColums= getHeadings();

        for (List<WebElement> row : rowsWithColums){
            rowByHeadings =new HashMap<String, WebElement>();
            for (int i = 0; i < headingsColums.size(); i++){
                String heading = headingsColums.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading,cell);
            }
            rowsWithColumsByHeadings.add(rowByHeadings);
            }
        return rowsWithColumsByHeadings;
    }

    public String getValueFromCell(int rowNumber, int columnumber){
        List<List<WebElement>> rowsWithColums = getRowsWithColums();
        WebElement cell = rowsWithColums.get(rowNumber-1).get(columnumber-1);
        return cell.getText();
    }

    public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumsByHeadings= getRowsWithColumsByHeadings();
        return rowsWithColumsByHeadings.get(rowNumber-1).get(columnName).getText();

    }


}
