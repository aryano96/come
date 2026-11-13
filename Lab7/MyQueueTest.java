// Q1 - Test class for MyQueue
public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println("isEmpty (new queue): " + queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Enqueued 10, 20, 30");
        System.out.println("getSize: " + queue.getSize());
        System.out.println("isEmpty: " + queue.isEmpty());

        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("getSize after dequeue: " + queue.getSize());

        queue.enqueue(40);
        System.out.println("Enqueued 40, getSize: " + queue.getSize());

        queue.dequeueAll();
        System.out.println("After dequeueAll -> getSize: " + queue.getSize()
                + ", isEmpty: " + queue.isEmpty());

        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            System.out.println("dequeue on empty queue: " + e.getMessage());
        }
    }
}
