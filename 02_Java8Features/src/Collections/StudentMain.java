package Collections;

import java.util.*;

public class StudentMain {

    public static void main(String[] args) {

        Set<Student> list = new TreeSet<Student>(new StudentNameSort());

        //List<Student> list1 = new ArrayList<Student>();
        list.add(new Student("vishal", 101, "Pune"));
        list.add(new Student("vishal", 102, "Pune"));
        list.add(new Student("vishal", 103, "Pune"));

       // Collections.sort(list, new StudentNameSort());

        for(Student stu:list){
            System.out.println(stu);
        }

        /*Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

    }
}
