package my.stack;

public class MyStackTest {
    public static void main(String[] args) {

        //Creation and filling a MyStack
        BasicStack<Integer> numbers = new MyStack<>();
        numbers.push(0);
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        numbers.push(4);
        numbers.push(5);

        //Getting an information about stack
        System.out.println("Stack after creation:");
        System.out.println("Stack of numbers - " + numbers);
        System.out.println("Peeked number is " + numbers.peek());
        System.out.println("Stack size - " + numbers.size());
        System.out.println("------------");

        //Removing an element
        System.out.println("Stack after removing " + numbers.remove(2));
        System.out.println("Stack of numbers - " + numbers);
        System.out.println("Peeked number is " + numbers.peek());
        System.out.println("Stack size - " + numbers.size());
        System.out.println("------------");

        //Removing an element
        System.out.println("Stack after pop - " + numbers.pop());
        System.out.println("Stack of numbers - " + numbers);
        System.out.println("Peeked number is " + numbers.peek());
        System.out.println("Stack size - " + numbers.size());
        System.out.println("------------");

        //Cleaning the stack
        numbers.clear();
        System.out.println("Peeked number is " + numbers.peek());
        System.out.println("------------");
    }
}
