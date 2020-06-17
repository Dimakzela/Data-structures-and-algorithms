package DSA.udemy.queue;

import org.junit.Assert;
import org.junit.Test;

public class MyQueueStackTest {
    private final String FIRST = "first";
    private final String SECOND = "second";
    private final MyQueue<String> queue = new MyQueueStack<>();

    @Test
    public void should_enqueue() {
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals(queue.size(), 0);

        queue.enqueue(FIRST);
        Assert.assertEquals(queue.peek(), FIRST);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(queue.size(), 1);

        queue.enqueue(SECOND);
        Assert.assertEquals(queue.peek(), FIRST);
        Assert.assertEquals(queue.size(), 2);

    }

    @Test
    public void should_dequeue() {
        queue.enqueue(SECOND);
        queue.enqueue(FIRST);
        Assert.assertEquals(queue.size(), 2);

        queue.dequeue();
        Assert.assertEquals(queue.peek(), FIRST);
        Assert.assertEquals(queue.size(), 1);

        queue.dequeue();
        Assert.assertTrue(queue.isEmpty());
    }
}
