package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lera on 09.06.2022
 */
public class Table {
    private WebElement tableElement;
    private WebDriver driver;

    public Table(WebElement tableElement, WebDriver driver){
        this.tableElement=tableElement;
        this.driver=driver;
    }

    public List<WebElement> getRows(){
        List<WebElement> rows=tableElement.findElements(By.xpath(".//div[@role='row']"));
        rows.remove(0);
        return rows;
    }

    public List<WebElement>getHeading(){
        WebElement headingsRow=tableElement.findElement(By.xpath(".//div[@role='row']"));
        List<WebElement> headingColumns=headingsRow.findElements(By.xpath(".//div[@role='columnheader']"));
        return headingColumns;
    }

    public List<List<WebElement>> getRowsWithColumns(){
        List<WebElement> rows=getRows();
        List<List<WebElement>> rowsWithColumns=new ArrayList<>();
        for (WebElement row:
                rows) {
            List<WebElement> rowWithColumn = row.findElements(By.xpath(".//div"));
            rowsWithColumns.add(rowWithColumn);
        }
        return rowsWithColumns;
    }
    public List<Map<String, WebElement>> getRowsWithColumnsByHeading(){
        List<List<WebElement>> rowsWithColumns=getRowsWithColumns();
        List<Map<String,WebElement>> rowsWithColumnsByHeadings =new ArrayList<>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns=getHeading();

        for (List<WebElement> row: rowsWithColumns) {
            rowByHeadings=new HashMap<>();
            for (int i=0; i<headingColumns.size(); i++){
                String headings=headingColumns.get(i).getText();
                WebElement cell=row.get(i);
                rowByHeadings.put(headings,cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }

    public String getValueCell(int rowNumber, String heading){
        List<Map<String, WebElement>> rowsWithColumnsByHeading =getRowsWithColumnsByHeading();
        WebElement cell=rowsWithColumnsByHeading.get(rowNumber-1).get(heading);
        return cell.getText();
    }
    public String getValueCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns =getRowsWithColumns();
        WebElement cell=rowsWithColumns.get(rowNumber-1).get(columnNumber-1);
        return cell.getText();
    }
}
