package com.opencart.utility;

import com.opencart.pojo.User;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCSV(String fileName) {
        FileReader csvFile;
        CSVReader csvReader;
        String[] line;
        List<User> userList;
        User userData;
        try {
            csvFile = new FileReader(System.getProperty("user.dir") + "/testdata/" + fileName);
            csvReader = new CSVReader(csvFile);
            csvReader.readNext(); //Reads the columns - Row 1 skip the columns
//            csvReader.readNext(); //Row 2
//            csvReader.readNext(); //Row 3
//            data = csvReader.readNext(); //Row 4 [If no row or we have reached the end of the CSV, readNext returns null]
            userList = new ArrayList<>();
            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
