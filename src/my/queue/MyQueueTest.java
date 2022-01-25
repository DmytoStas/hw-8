package my.queue;

public class MyQueueTest {
    public static void main(String[] args) {

        //Creation and filling a MyQueue
        BasicQueue<String> names = new MyQueue<>();
        names.add("Dmytro");
        names.add("Vova");
        names.add("Olesia");
        names.add("Masha");
        names.add("Alex");

        //Getting an information about queue
        System.out.println("Queue after creation:");
        System.out.println("Names queue - " + names);
        System.out.println("Peeked name is " + names.peek());
        System.out.println("Queue size - " + names.size());
        System.out.println("------------");

        //Removing an element
        System.out.println("Queue after removing " + names.remove(2));
        System.out.println("Names queue - " + names);
        System.out.println("Peeked name is " + names.peek());
        System.out.println("Queue size - " + names.size());
        System.out.println("------------");

        //Polling an element
        System.out.println("Queue after poll - " + names.poll());
        System.out.println("Names queue - " + names);
        System.out.println("Peeked name is " + names.peek());
        System.out.println("Queue size - " + names.size());
        System.out.println("------------");

        //Cleaning the queue
        names.clear();
        System.out.println("Peeked name is " + names.peek());
        System.out.println("------------");
    }
}
