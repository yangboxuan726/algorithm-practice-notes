import java.util.HashMap;
import java.util.Map;

public class LRU缓存 {
    //https://leetcode.cn/problems/lru-cache/?envType=study-plan-v2&envId=top-100-liked
    // 双向链表节点
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    // key -> Node
    private Map<Integer, Node> map;

    // 虚拟头尾节点
    private Node head;
    private Node tail;

    public LRU缓存(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = map.get(key);

        if (node == null) {
            return -1;
        }

        // 访问过，变成最近使用
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        Node node = map.get(key);

        // key 已经存在
        if (node != null) {
            node.value = value;

            // 更新后也算使用一次
            moveToHead(node);
            return;
        }

        // key 不存在，创建新节点
        Node newNode = new Node(key, value);

        // 放进 HashMap
        map.put(key, newNode);

        // 新节点是最近使用的
        addToHead(newNode);

        // 超过容量，删除最久未使用的节点
        if (map.size() > capacity) {

            Node removed = removeTail();

            map.remove(removed.key);
        }
    }

    // 把节点加到头部
    private void addToHead(Node node) {

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 从双向链表中删除某个节点
    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 把某个节点移动到头部
    private void moveToHead(Node node) {

        removeNode(node);
        addToHead(node);
    }

    // 删除最久未使用节点
    private Node removeTail() {

        Node node = tail.prev;

        removeNode(node);

        return node;
    }
}

