package fileHandling;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFile {
    public static void main(String[] args){

        String path = "E:\\FileHandling\\Employee.csv";

        //Write Files
        try (CSVWriter csv = new CSVWriter(new FileWriter(path))) {
            String[] header = {"Id", "Name", "Address"};
            csv.writeNext(header);
            String[] values = {"101", "VISHAL", "PUNE"};
            csv.writeNext(values);
            String[] values1 = {"102", "SAURABH", "PUNE"};
            csv.writeNext(values1);
            String[] values2 = {"103", "SAHIL", "PUNE"};
            csv.writeNext(values2);

            System.out.println("Csv File Created SuccessFully....");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Read Files

        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {

            String[] readData;
            while ((readData = csvReader.readNext()) != null) {
                System.out.println("Id: " + readData[0] + ", Name: " + readData[1] + ", Address: " + readData[2]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
