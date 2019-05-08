package kz.primesource.utilities;



import kz.primesource.base.BaseTest;
import kz.primesource.business_objects.User;
import org.testng.annotations.DataProvider;

import java.util.Hashtable;

public class DataProviderClass extends BaseTest {
    @DataProvider
    public Object[][] dataForLoginTest(){
        return new Object[][]{
                {new User("7773557661","Aass1212!")}
        };
    }






    @DataProvider
    public Object[][] excelData(){

        String sheetName = "PIL";

        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows-1][cols];

        for (int rowNum = 2; rowNum < rows; rowNum++) {
            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }










}
