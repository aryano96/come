// Q2 - Grocery store with two register lines (uses MyQueue from Q1, unmodified)
public class GroceryStore {

    private MyQueue<String> register1;
    private MyQueue<String> register2;

    public GroceryStore() {
        register1 = new MyQueue<>();
        register2 = new MyQueue<>();
    }

    // Adds the customer to the shortest register line (register 1 on a tie)
    public void checkout(String name) {
        if (register1.getSize() <= register2.getSize()) {
            register1.enqueue(name);
        } else {
            register2.enqueue(name);
        }
    }

    // Moves all customers from register 1 to register 2
    public void closeReg1() {
        while (!register1.isEmpty()) {
            register2.enqueue(register1.dequeue());
        }
    }

    // Moves all customers from register 2 to register 1
    public void closeReg2() {
        while (!register2.isEmpty()) {
            register1.enqueue(register2.dequeue());
        }
    }

    // Labels and prints both checkout lines without changing them
    public void printLines() {
        System.out.println("Register 1: " + lineToString(register1));
        System.out.println("Register 2: " + lineToString(register2));
    }

    // Builds the line as text by cycling each customer to the back,
    // so the queue ends up in its original order
    private String lineToString(MyQueue<String> line) {
        String result = "front ->";
        int size = line.getSize();
        for (int i = 0; i < size; i++) {
            String customer = line.dequeue();
            result += (i == 0 ? " " : ", ") + customer;
            line.enqueue(customer);
        }
        return result;
    }

    public static void main(String[] args) {
        GroceryStore store = new GroceryStore();

        store.checkout("George");
        store.checkout("Rachel");
        store.checkout("Sofia");
        store.checkout("Josh");
        store.checkout("Alice");

        System.out.println("After checkout:");
        store.printLines();

        System.out.println("\nPrint again (lines should be unchanged):");
        store.printLines();

        store.closeReg2();
        System.out.println("\nAfter closeReg2:");
        store.printLines();

        store.closeReg1();
        System.out.println("\nAfter closeReg1:");
        store.printLines();

        store.checkout("Mike");
        System.out.println("\nAfter checkout Mike:");
        store.printLines();
    }
}
