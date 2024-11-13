package logics;

import java.util.*;

public class StreamConcept {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);

        Optional thirdHighest = list.stream().sorted((a, b) -> b-a).skip(2).findFirst();

        if(thirdHighest.isPresent()){
            System.out.println(thirdHighest.get());
        }
    }
}
