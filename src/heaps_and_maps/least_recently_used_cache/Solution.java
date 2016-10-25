package heaps_and_maps.least_recently_used_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ugurdonmez on 19/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        Solution solution = new Solution(2);
        solution.set(2,1);
        solution.set(1,1);
        solution.set(2,3);
        solution.set(4,1);
        System.out.println(solution.get(1));
        System.out.println(solution.get(2));
        solution.set(5,1);
        solution.set(6,1);
        solution.set(7,1);

    }


    private final int capacity;

    private int size;

    Map<Integer, CacheNode> map;

    private CacheNode head;
    private CacheNode tail;

    public Solution(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;

        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key).getValue();
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {

        if (map.containsKey(key)) {
            map.get(key).setValue(value);

            CacheNode node = map.get(key);

            if (this.capacity != 1) {
                if (node.getNext() != null) {
                    node.getNext().setPrev(node.getPrev());
                }

                if (node.getPrev() != null) {
                    node.getPrev().setNext(node.getNext());
                } else {
                    head = head.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    }
                }

                node.setNext(null);
                tail.setNext(node);
                node.setPrev(tail);
                tail = tail.getNext();
            }

        } else {
            if (this.size < this.capacity) {
                CacheNode node = new CacheNode(key, value);
                if (tail != null) {
                    tail.setNext(node);
                    tail.getNext().setPrev(tail);
                    tail = tail.getNext();
                } else {
                    tail = head = node;
                }
                map.put(key, node);
                this.size++;
            } else {
                CacheNode temp = head;
                head = head.getNext();

                if (head == null) {
                    CacheNode node = new CacheNode(key, value);
                    head = tail = node;
                    map.remove(temp.getKey());
                    map.put(key, node);
                } else {
                    head.setPrev(null);
                    temp.setNext(null);
                    map.remove(temp.getKey());

                    CacheNode node = new CacheNode(key, value);
                    map.put(key, node);
                    tail.setNext(node);
                    tail.getNext().setPrev(tail);
                    tail = tail.getNext();
                }
            }
        }
    }
}

class CacheNode {

    private final int key;
    private int value;

    private CacheNode next;
    private CacheNode prev;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public CacheNode getNext() {
        return next;
    }

    public CacheNode getPrev() {
        return prev;
    }

    public void setNext(CacheNode next) {
        this.next = next;
    }

    public void setPrev(CacheNode prev) {
        this.prev = prev;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
