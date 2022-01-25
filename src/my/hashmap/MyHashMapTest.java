package my.hashmap;

public class MyHashMapTest {
    public static void main(String[] args) {

        //Creation and filling a MyHashMap
        BasicHashMap<Integer, String> schoolClass = new MyHashMap<>();
        schoolClass.put(1, "Nene");
        schoolClass.put(2, "Madqa");
        schoolClass.put(3, "Madsdfqa");
        schoolClass.put(4, "Werfg");
        schoolClass.put(5, "Mfbd");
        schoolClass.put(6, "Sfdg");
        schoolClass.put(6, "Il");
        schoolClass.put(5, "Pjni");
        schoolClass.put(4, "Fdgdeeg");
        schoolClass.put(3, "Qerwfg");
        System.out.println("------------");

        //Getting an information about MyHashMap
        System.out.println("MyHashMap after creation:");
        System.out.println(schoolClass.get(6));
        System.out.println("Size is - " + schoolClass.size());
        System.out.println("------------");

        //Removing an element
        System.out.println("MyHashMap after removing:");
        schoolClass.remove(6);
        System.out.println(schoolClass.get(5));
        System.out.println("Size is - " + schoolClass.size());
        System.out.println("------------");

        //Cleaning the MyHashMap
        schoolClass.clear();
        System.out.println("MyHashMap after cleaning:");
        System.out.println(schoolClass.get(2));
        System.out.println("Size is - " + schoolClass.size());
    }
}


