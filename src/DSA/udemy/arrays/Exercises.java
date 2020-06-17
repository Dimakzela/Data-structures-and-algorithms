package DSA.udemy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exercises {
    public static String reverseString(String stringToReverse) {
        int strLength = stringToReverse.length();
        if (strLength < 2) return stringToReverse;
        StringBuilder sb = new StringBuilder();
        for (int i = strLength - 1; i >= 0; i--) {
            sb.append(stringToReverse.charAt(i));
        }

        return sb.toString();
    }

    public static String reverseString2(String stringToReverse) {
        StringBuilder sb = new StringBuilder(stringToReverse);
        return sb.reverse().toString();
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int array1Length = array1.length;
        int array2Length = array2.length;

        if(array1Length == 0) return array2;
        if(array2Length == 0) return array1;

        int[] result = new int[array1Length + array2Length];
        int resultPosition = 0, array1Position = 0, array2Position = 0;

        while (array1Position < array1Length && array2Position < array2Length ) {
            if(array1[array1Position] < array2[array2Position]) {
                result[resultPosition++] = array1[array1Position++];
            }else {
                result[resultPosition++] = array2[array2Position++];
            }
        }

        while (array1Position < array1Length) {
            result[resultPosition++] = array1[array1Position++];
        }

        while (array2Position < array2Length) {
            result[resultPosition++] = array2[array2Position++];
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] results = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                results = new int[]{map.get(nums[i]), i};
            }else {
                map.put(target - nums[i], i);
            }
        }
        return results;
    }

    //Naive O(n^2)
    public static int maxSubArray(int[] nums) {
        int maxSubArray = Integer.MIN_VALUE;
        for(int outerCount = 0; outerCount < nums.length; outerCount++) {
            int sum = 0;
            for(int innerCount = outerCount; innerCount < nums.length; innerCount++) {
                sum += nums[innerCount];
                if(sum > maxSubArray) maxSubArray = sum;
            }
        }
        return maxSubArray;
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int value: nums) {
            if(!set.add(value)) return true;
        }
        return false;
    }

    //Naive O(n^2)
    public static int[] moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] == 0 && j != nums.length - 1) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }

    //Naive O(n^2)
    public static void rotate(int[] nums, int k) {
        for(int i = 1; i <= k; i++) {
            int last = nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++) {
                if(j != nums.length - 1) nums[j + 1] = nums[j];
            }
            nums[0] = last;
        }
    }
}
