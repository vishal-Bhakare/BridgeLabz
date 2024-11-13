package Collections;

public class Student  {

    private String name;
    private int rollno;
    private String address;

    public Student(String name, int rollno, String address) {
        this.name = name;
        this.rollno = rollno;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno=" + rollno +
                ", address='" + address + '\'' +
                '}';
    }

}
