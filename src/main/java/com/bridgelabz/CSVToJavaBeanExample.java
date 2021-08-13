package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVToJavaBeanExample {

    private static final String CSV_FILE_PATH = "users.csv";
    public static void main(String[] args) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));

        CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                .withType(CSVUser.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<CSVUser> itr = csvToBean.iterator();

        while (itr.hasNext()) {
            CSVUser csvUser = itr.next();
            System.out.println("Name : " + csvUser.getName());
            System.out.println("Email : " + csvUser.getEmail());
            System.out.println("Phone : " + csvUser.getPhone());
            System.out.println("Country : " + csvUser.getCountry());
        }


    }
}