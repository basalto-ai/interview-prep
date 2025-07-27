package xyz.basalto.interprep.basic.queue;

import java.util.Iterator;

import xyz.basalto.interprep.ds.XyzSinglyLinkedQueue;

public class ReverseQueue {

    public static <T> XyzSinglyLinkedQueue<T> reverse(XyzSinglyLinkedQueue<T> queue) {
        XyzSinglyLinkedQueue<T> reversedQueue = new XyzSinglyLinkedQueue<>();
        while (!queue.isEmpty()) {
            T element = queue.remove();
            reversedQueue.add(element);
        }
        return reversedQueue;
    }

    public static <T> XyzSinglyLinkedQueue<T> reverseWithoutRemoving(XyzSinglyLinkedQueue<T> queue) {
        XyzSinglyLinkedQueue<T> reversedQueue = new XyzSinglyLinkedQueue<>();
        Iterator<T> iterator = queue.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            reversedQueue.add(element);
        }
        return reversedQueue;
    }

}
