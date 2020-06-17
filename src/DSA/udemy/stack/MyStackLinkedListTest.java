package DSA.udemy.stack;

import org.junit.Assert;
import org.junit.Test;

public class MyStackLinkedListTest {

    private final int FIRST = 1;
    private final int SECOND = 2;
    private final MyStack<Integer> stack = new MyStackLinkedList<>();

    @Test
    public void should_push() {
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(stack.size(), 0);

        stack.push(FIRST);
        stack.push(SECOND);
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(stack.size(), 2);

        stack.push(SECOND);
        Assert.assertEquals((int)stack.peek(), SECOND);

    }

    @Test
    public void should_pop() {
        stack.push(SECOND);
        stack.push(FIRST);
        Assert.assertEquals(stack.size(), 2);

        //Pop element
        int popped = stack.pop();
        Assert.assertEquals(popped, FIRST);
        Assert.assertEquals(stack.size(), 1);

        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }

}
