// Q1 - Generic reference-based Queue
public class MyQueue<T> {

    // Inner class: Node
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node back;
    private int size;

    // No-arg constructor only
    public MyQueue() {
        front = null;
        back = null;
        size = 0;
    }

    // Returns true when the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Adds a new generic item to the end of the queue
    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            back.next = newNode;
        }
        back = newNode;
        size++;
    }

    // Removes and returns the item at the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T item = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            back = null;
        }
        return item;
    }

    // Dequeues all items from the queue
    public void dequeueAll() {
        front = null;
        back = null;
        size = 0;
    }

    // Returns the number of items in the queue
    public int getSize() {
        return size;
    }
}
