package my.array.list;

public class MyArrayListTest {
    public static void main(String[] args) {

        //Creation and filling a MyArrayList
        BasicArrayList<String> names = new MyArrayList<>();
        names.add("Alex");
        names.add("Petr");
        names.add("Pasha");
        names.add("Valera");

        //Getting an information about array
        System.out.println("Array after creation:");
        System.out.println("Names list - " + names);
        System.out.println("Element is " + names.get(2));
        System.out.println("Array size - " + names.size());
        System.out.println("--------------");

        //Removing an element
        System.out.println("Array after removing " + names.remove(2));
        System.out.println("Names list - " + names);
        System.out.println("Element is " + names.get(2));
        System.out.println("Array size - " + names.size());
        System.out.println("--------------");

        //Cleaning the array
        System.out.println("Array after cleaning:");
        names.clear();
        System.out.println("Element is " + names.get(2));
    }
}
