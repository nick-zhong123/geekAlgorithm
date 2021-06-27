package com.geek.algorithm.homework.week2;

import java.util.HashMap;

/**
 *
 * @author nick
 * @date 2021/6/27 3:43 PM
 * @package com.geek.algorithm.homework.week2
 * @description
 *
 *
 */
public class LRU146 {

    private class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node() {}

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    public LRU146(int capacity) {
        this.capacity = capacity;
        // 做好保护节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     *
     * O(1)获取数据
     * @param key
     *
     */
    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        Node node = this.map.get(key);
        // 从链表中删除，放入头部
        removeFromList(node);
        insertIntoListHead(node.key, node.value);
        return node.value;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            removeFromList(node);
            // put可能key相同，但是value值不一样
            insertIntoListHead(node.key, value);
        } else {
            insertIntoListHead(key, value);
        }
        // 如果超出容量，要删除尾部节点。双链表和MAP都要删除
        if (this.capacity < this.map.size()) {
            removeFromList(tail.prev);
        }
    }

    /**
     *
     * 从头节点插入，写入map
     *
     * @param key
     * @param value
     */
    private void insertIntoListHead(int key, int value) {
        Node node = new Node(key, value);
        // 将node与双链表建立链接
        node.next = head.next;
        node.prev = head;
        // 将head与head.next与node建立链接
        head.next.prev = node;
        head.next = node;
        this.map.put(key, node);
    }

    /**
     *
     * 从链表删除，从map删除
     *
     * @param node
     */
    private void removeFromList(Node node) {
        // 将node的前后节点建立联系，置空node
        node.next.prev = node.prev;
        node.prev.next = node.next;
        // 从hashmap中删除key
        this.map.remove(node.key);
    }

    public void printLRU() {
        Node node = head.next;
        System.out.println("-------start------");
        while(node != tail) {
            System.out.println("Key:" + node.key + ",value:" + node.value);
            node = node.next;
        }
        System.out.println("-------end------");
    }

    public static void main(String[] args) {
//        LRU146 lru = new LRU146(3);
//        // 初始化三个值
//        lru.put(1, 11); lru.printLRU();
//        lru.put(2, 22); lru.printLRU();
//        lru.put(3, 33); lru.printLRU();
//        // 超过容量，将key 1删除
//        lru.put(4, 44); lru.printLRU();
//        // 再次put key 3, 3变成第一个节点
//        lru.put(3, 3); lru.printLRU();
//        // get key 2, 2变成第一个节点
//        lru.get(2); lru.printLRU();
        LRU146 lru = new LRU146(2);
        lru.put(2, 1); lru.printLRU();
        lru.put(2, 2); lru.printLRU();
        lru.get(2); lru.printLRU();
        lru.put(1, 1); lru.printLRU();
        lru.put(4, 1); lru.printLRU();
        lru.get(2); lru.printLRU();
    }
}
