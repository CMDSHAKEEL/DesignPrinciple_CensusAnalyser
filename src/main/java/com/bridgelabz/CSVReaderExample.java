package com.bridgelabz;


import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class CSVReaderExample {

    private static final String CSV_FILE_PATH = "users.csv";
    public static void main(String[] args) {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);

//Approach One
            String[] nextRecord;

            System.out.println("================Approach One ======================");

            while (Objects.nonNull((nextRecord = csvReader.readNext()))) {

                System.out.println("Name : " + nextRecord[0]);
                System.out.println("Email : " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                System.out.println("Country : " + nextRecord[3]);
            }
//Approach two
            Reader reader1 = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVReader csvReader1 = new CSVReader(reader1);
            List<String[]> allRecords = csvReader1.readAll();

            System.out.println("================Approach Two ======================");
            for(String[] record : allRecords) {
                System.out.println("Name : " + record[0]);
                System.out.println("Email : " + record[1]);
                System.out.println("Phone : " + record[2]);
                System.out.println("Country : " + record[3]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}