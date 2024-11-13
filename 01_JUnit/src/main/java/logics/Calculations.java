package logics;

import java.util.Arrays;

public class Calculations {


    public static int addTwoNo(int a, int b) {
        return a + b;
    }

    public static int multiTwoNo(int a, int b) {
        return a * b;
    }

    public static int addNumbers(int... num) {

        int sum = 0;
        for (int no : num) {
            sum += no;
        }
        return sum;
    }

    public static boolean checkIsogram(String inputString) {

        inputString = inputString.toLowerCase();
        int stringLength = inputString.length();

        char characterArray[] = inputString.toCharArray();
        Arrays.sort(characterArray);
        for (int i = 0; i < stringLength - 1; i++) {
            if (characterArray[i] == characterArray[i + 1])
                return false;
        }
        return true;
    }

    public boolean checkAnagram(String inputString1,
                                String inputString2){

        inputString1 = inputString1.toLowerCase();
        inputString2 = inputString2.toLowerCase();
        int str1Length = inputString1.length();
        int str2Length = inputString2.length();

        if (str1Length != str2Length) {
            return false;
        }

        char[] str1 = inputString1.toCharArray();
        char[] str2 = inputString2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int index = 0; index < str1Length; index++) {
            if (str1[index] != str2[index])
                return false;
        }
        return true;
    }





}


