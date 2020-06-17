package DSA.udemy.hashtables;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Exercises {

    public Integer firstRecurring(int[] array) {
        Set<Integer> set = new HashSet<>();
        for(int num: array) {
            if(!set.add(num)) return num;
        }
        return null;
    }

    @Test
    public void should_return_first_recurring() {
        int[] array1 = new int[]{1, 2, 3, 5, 4, 2, 1, 1};
        int[] array2 = new int[]{1, 1, 3, 5, 4, 2, 1, 1};
        int[] array3 = new int[]{1, 3, 2, 3, 4, 2, 1, 1};
        int[] array4 = new int[]{1, 3, 2, 4};
        Assert.assertEquals(firstRecurring(array1), new Integer(2));
        Assert.assertEquals(firstRecurring(array2), new Integer(1));
        Assert.assertEquals(firstRecurring(array3), new Integer(3));
        Assert.assertNull(firstRecurring(array4));
    }
}
