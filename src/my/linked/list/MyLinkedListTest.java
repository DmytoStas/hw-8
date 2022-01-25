package my.linked.list;

public class MyLinkedListTest {
    public static void main(String[] args) {

        //Creation and filling a MyLinkedList
        BasicLinkedList<String> names = new MyLinkedList<>();
        names.add("Bogdan");
        names.add("Ivan");
        names.add("Pavel");
        names.add("Dmytro");
        names.add("Oleg");

        //Getting an information about list
        System.out.println("List after creation:");
        System.out.println("Names list - " + names);
        System.out.println("List size " + names.size());
        System.out.println("Selected item is " + names.get(5));
        System.out.println("-----------");

        //Removing an element
        System.out.println("List after removing");
        names.remove(5);
        System.out.println("Names list - " + names);
        System.out.println("List size " + names.size());
        System.out.println("Selected item is " + names.get(5));
        System.out.println("-----------");

        //Cleaning the list
        System.out.println("List after cleaning:");
        names.clear();
        System.out.println("Names list - " + names);
        System.out.println("-----------");
    }
}
