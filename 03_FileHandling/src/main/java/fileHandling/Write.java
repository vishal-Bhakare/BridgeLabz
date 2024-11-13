package fileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

    public static void main(String[] args) {

        // File Write
        try {
            File file = new File("E:\\FileHandling\\Java.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello Java I am Vishal");
           // System.out.println(file.getAbsoluteFile()+" File Name : "+file.getName());
            fileWriter.close();
            System.out.println("File is Created Successfully");

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        //File Read
        try{
            File file = new File("E:\\FileHandling\\Java.txt");
            FileReader reader = new FileReader(file);
            int read ;
            while ((read = reader.read()) != -1){
                System.out.print((char)read);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
