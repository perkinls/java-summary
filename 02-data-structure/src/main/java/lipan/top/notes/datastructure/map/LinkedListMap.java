package lipan.top.notes.datastructure.map;

/**
 * @author li.pan
 * @title 基于链表实现的Map
 */
public class LinkedListMap<K, V> implements IMap<K, V> {

    /**
     * 链表的节点结构，节点中会存储键值对，而不是单个元素
     */
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private final Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 根据传入的key获取链表中的节点
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            // key不存在，往链表的头部插入新元素
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            // 否则，改变value
            node.value = value;
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        node.value = newValue;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        // 根据key找到待删除节点的前一个节点
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            // 删除目标节点
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;

            return delNode.value;
        }

        return null;
    }
}