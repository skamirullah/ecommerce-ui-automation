package com.opencart.utility;

import com.opencart.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtil {

    public static Iterator<User> readExcel(String fileName) {
        File excelFile = new File(System.getProperty("user.dir") + "/testdata/" + fileName);
        XSSFWorkbook xssfWorkbook;
        List<User> userList;
        Row row;
        Cell emailCell;
        Cell passwordCell;
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;
        User user;
        try {
            xssfWorkbook = new XSSFWorkbook(excelFile);
            userList = new ArrayList<>();
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            rowIterator = xssfSheet.iterator();
            rowIterator.next(); //skipping he column name
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailCell.toString(), passwordCell.toString());
                userList.add(user);
            }
            xssfWorkbook.close();

        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
