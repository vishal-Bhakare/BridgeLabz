package fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteWithScanner {

    public static void main(String[] args) {

        try {
            // Create a file object
            File file = new File("E:\\FileHandling\\ScannerDemo.txt");

            // Check if file exists, if not create the file and write initial content
            if (!file.exists()) {
                System.out.println("File does not exist. Creating file...");
                file.createNewFile(); // Creates a new empty file

                // Writing some initial content to the file using FileWriter
                FileWriter writer = new FileWriter(file);
                writer.write("This is a sample text written to the file.\n");
                writer.write("This file is now created and ready for reading.\n");
                writer.close();
                System.out.println("File created and written successfully.");
            }

            // Reading from the file using Scanner
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String msg = sc.nextLine();
                System.out.println(msg);
            }
            sc.close();

        } catch (FileNotFoundException exception) {
            System.out.println("Error occurred: File not found.");
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred while creating or writing to file.");
            System.out.println(e.getMessage());
        }
    }
}
