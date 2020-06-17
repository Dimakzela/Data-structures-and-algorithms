package DSA.udemy.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void should_append_element() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("Head");
        Assert.assertEquals(myLinkedList.size(), 1);

        myLinkedList.append("second");
        Assert.assertEquals(myLinkedList.size(), 2);
        Assert.assertEquals(myLinkedList.getFirst(), "Head");
        Assert.assertEquals(myLinkedList.getLast(), "second");

    }

    @Test
    public void should_prepend_element() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("Tail");
        Assert.assertEquals(myLinkedList.size(), 1);

        myLinkedList.prePend("second");
        Assert.assertEquals(myLinkedList.size(), 2);
        Assert.assertEquals(myLinkedList.getFirst(), "second");
        Assert.assertEquals(myLinkedList.getLast(), "Tail");
    }

    @Test
    public void should_get_element_at_index() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.append("head");
        myLinkedList.append("first");
        myLinkedList.append("second");
        myLinkedList.append("third");
        myLinkedList.append("last");

        Assert.assertEquals(myLinkedList.get(0), "head");
        Assert.assertEquals(myLinkedList.get(1), "first");
        Assert.assertEquals(myLinkedList.get(3), "third");
    }

    @Test
    public void should_insert_at_index() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        Assert.assertTrue(myLinkedList.isEmpty());

        myLinkedList.append("first");
        myLinkedList.append("second");
        myLinkedList.append("third");

        myLinkedList.insert("forth", 2);
        Assert.assertEquals(myLinkedList.get(2), "forth");
    }

    @Test
    public void should_remove_first() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.append("Head");
        myLinkedList.append("second");
        myLinkedList.append("second");

        myLinkedList.removeFirst();

        Assert.assertEquals(myLinkedList.getFirst(), "second");
    }

    @Test
    public void should_remove_at_index() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.append("Head");
        myLinkedList.append("second");
        myLinkedList.append("third");

        Assert.assertTrue(myLinkedList.contains("second"));

        myLinkedList.remove(1);

        Assert.assertFalse(myLinkedList.contains("second"));
    }
}
