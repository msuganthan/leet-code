package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedList {
        int key;
        int value;
        DLinkedList prev;
        DLinkedList post;
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedList();
        head.prev = null;

        tail = new DLinkedList();
        tail.post = null;

        head.post = tail;
        tail.prev  = head;
    }

    Map<Integer, DLinkedList> cache = new HashMap<>();
    int capacity;
    int count;
    DLinkedList head, tail;

    void removeNode(DLinkedList node) {

        DLinkedList prev = node.prev;
        DLinkedList post = node.post;

        prev.post = post;
        post.prev = prev;
    }

    DLinkedList	popTail() {
        DLinkedList lastNode = tail.prev;
        this.removeNode(lastNode);
        return lastNode;
    }

    void moveToHead(DLinkedList node) {
        this.removeNode(node);
        this.addNode(node);
    }

    void addNode(DLinkedList newNode) {
        newNode.prev = head;
        newNode.post = head.post;

        head.post.prev = newNode;
        head.post = newNode;
    }

    int get(int key) {
        DLinkedList node = cache.get(key);

        if(node == null)
            return -1;

        this.moveToHead(node);

        return node.value;
    }

    void put(int key, int value) {
        DLinkedList node = cache.get(key);
        if(node == null) {
            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;

            if(this.count > capacity) {
                DLinkedList removedNode = this.popTail();
                this.cache.remove(removedNode.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        lruCache.get(1);

        lruCache.put(3, 3);

        lruCache.get(2);
    }
}
