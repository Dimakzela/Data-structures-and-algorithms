package DSA.udemy.interviewqestions;

import java.util.HashSet;

public class Question1 {
    public static boolean containsCommonItem(char[] array1, char[] array2) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < array1.length; i++) {
            if(set.contains(array1[i])) return true;
            if(i < array2.length) set.add(array2[i]);
        }
        return false;
    }
}
