package hashing.constant_time_hashmap;

/**
 * Created by ugurdonmez on 16/08/16.
 */
public class Main {

    public static void main(String [] args) {

        MyMap map = new MyMap();

        map.insert(0,5);
        map.insert(5,2);
        map.insert(10,7);
        map.insert(4,8);

        System.out.println(map.getRandomKey());
        System.out.println(map.getRandomKey());
        System.out.println(map.getRandomKey());
        System.out.println(map.getRandomKey());
        System.out.println(map.getRandomKey());
        System.out.println(map.getRandomKey());
        System.out.println(map.getRandomKey());

        System.out.println();
        System.out.println(map.get(10));

        map.delete(10);

        System.out.println();
    }

}
