package DSA.udemy.stack;

import org.junit.Assert;
import org.junit.Test;

public class MyStackArrayTest {

    private final int FIRST = 1;
    private final int SECOND = 2;
    private MyStack<Integer> stack;

    @Test
    public void should_push() {
        stack = new MyStackArray<>();
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(stack.size(), 0);

        stack.push(FIRST);
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals((int)stack.peek(), FIRST);

        stack.push(SECOND);
        Assert.assertEquals((int)stack.peek(), SECOND);

    }

    @Test
    public void should_pop() {
        stack = new MyStackArray<>();
        stack.push(SECOND);
        stack.push(FIRST);
        Assert.assertEquals(stack.size(), 2);

        int popped = stack.pop();
        Assert.assertEquals(popped, FIRST);
        Assert.assertEquals(stack.size(), 1);

        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }
}
