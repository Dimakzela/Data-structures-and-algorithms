package DSA.udemy.hashtables;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyHashTableTest {

    @Test
    public void should_put_and_get_value() {

        MyHashTable<Integer, String> table = new MyHashTable<>();

        //Table is empty
        Assert.assertTrue(table.isEmpty());
        Assert.assertEquals(table.size(), 0);

        //Put values
        table.put(1, "One");
        table.put(2, "Two");

        //Table is not empty
        Assert.assertFalse(table.isEmpty());
        Assert.assertEquals(table.size(), 2);

        //Get values
        Assert.assertEquals(table.get(1), "One");
        Assert.assertEquals(table.get(2), "Two");

        //Get Keys
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        Assert.assertEquals(table.keys(), set);
    }
}
