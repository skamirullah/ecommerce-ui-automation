package com.opencart.dataprovider;

import com.google.gson.Gson;
import com.opencart.pojo.TestData;
import com.opencart.pojo.User;
import com.opencart.utility.CSVReaderUtilty;
import com.opencart.utility.ExcelReaderUtil;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider(){
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "//testdata/loginData.json");
        FileReader fileReader;
        try {
            fileReader = new FileReader(testDataFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        TestData data = gson.fromJson(fileReader, TestData.class);

        List<Object[]> dataToReturn  = new ArrayList<>();
        for (User user: data.getData()){
            dataToReturn.add(new Object[] {user});
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<User> loginCSVDataProvider(){
        return CSVReaderUtilty.readCSV("loginData.csv");
    }

    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<User> loginExcelDataProvider(){
        return ExcelReaderUtil.readExcel("loginData.xlsx");
    }
}
