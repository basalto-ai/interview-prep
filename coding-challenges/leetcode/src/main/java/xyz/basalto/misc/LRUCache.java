package xyz.basalto.misc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> cache;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node node = cache.get(key);
        if (node == null) return - 1;

        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value){
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node);
        } else {
            if (cache.size() == capacity){
                Node lruNode = tail.prev;
                remove(lruNode);
                cache.remove(lruNode.key);
            }

            Node newNode = new Node(key, value);
            addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
