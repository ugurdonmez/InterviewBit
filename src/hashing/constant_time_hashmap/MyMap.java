package hashing.constant_time_hashmap;

import java.util.*;

/**
 * Created by ugurdonmez on 16/08/16.
 */
public class MyMap {

    private Map<Integer, Integer> objectKeyArrayKey;
    private Map<Integer, Integer> arrayKeyObjectKey;

    private List<Integer> objectArray;

    public MyMap() {
        this.objectKeyArrayKey = new HashMap<>();
        this.arrayKeyObjectKey = new HashMap<>();
        this.objectArray = new ArrayList<>();
    }

    public void insert(int key, int value) {

        this.objectArray.add(value);

        int arrayIndex = this.objectArray.size() - 1;

        this.objectKeyArrayKey.put(key, arrayIndex);
        this.arrayKeyObjectKey.put(arrayIndex, key);
    }

    public int get(int key) {
        return this.objectArray.get(objectKeyArrayKey.get(key));
    }

    public int getRandomKey() {
        Random random = new Random();

        return this.arrayKeyObjectKey.get(random.nextInt(objectArray.size()));
    }

    public void delete(int key) {

        // find index in array
        int index = objectKeyArrayKey.get(key);
        int arrayLastIndex = this.objectArray.size() - 1;

        this.objectArray.set(index, this.objectArray.get(arrayLastIndex));
        int replacedObjectKey = this.arrayKeyObjectKey.get(arrayLastIndex);

        this.arrayKeyObjectKey.put(index, replacedObjectKey);
        this.objectKeyArrayKey.put(replacedObjectKey, index);

        this.arrayKeyObjectKey.remove(arrayLastIndex);
        this.objectKeyArrayKey.remove(key);
        this.objectArray.remove(arrayLastIndex);
    }
}
