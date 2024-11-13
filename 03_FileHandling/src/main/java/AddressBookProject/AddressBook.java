package AddressBookProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressBook {

    List<Person> listPerson = new ArrayList<Person>();

    public void addPerson(Person person) {
        listPerson.add(person);
        saveEmployeeFile();
        System.out.println("Person Added SuccessFully \n");
    }

    public void listOfPerson() {

        if (listPerson.isEmpty()) {

            System.out.println("Person List Is Empty \n");
        } else {

            for (Person person : listPerson) {
                System.out.println(person);
            }
        }

    }

    public void updatePerson(String firstName, String state, String city, int pincode, double salary) {

        for (Person person : listPerson) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                person.setState(state);
                person.setCity(city);
                person.setPincode(pincode);
                person.setSalary(salary);
                saveEmployeeFile();
                System.out.println("Person Update Successfully");
                return;
            }
        }

        System.out.println("Person Is Not Found....");
    }

    public void deletePerson(String firstName) {

        Person deletePerson = null;
        for (Person person : listPerson) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                deletePerson = person;
                break;
            }
        }

        if (deletePerson != null) {
            listPerson.remove(deletePerson);
            saveEmployeeFile();
            System.out.println("Person Delete SuccessFully");
        } else {
            System.out.println("Person Is Not Found....");
        }
    }

    private void saveEmployeeFile() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\FileHandling\\AddressBookApplicatin.txt"))) {
            for (Person person : listPerson) {
                bufferedWriter.write(person.toFileString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error Occured Save File : " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\FileHandling\\AddressBookApplicatin.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String firstName = data[0];
                String lastName = data[1];
                String state = data[2];
                String city = data[3];
                int pincode = Integer.parseInt(data[4]);
                double salary = Double.parseDouble(data[5]);
                Date date = new Date();
                listPerson.add(new Person(firstName, lastName, state, city, pincode, salary, date));
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        } catch (CustomValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
