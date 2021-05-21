package lipan.top.notes.datastructure.linkedlist;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 链表基本实现v2版本
 * @createTime 2021年05月20日 14:11:00
 * <p>
 * 使用虚拟头节点处理v1版本中针对于头节点单独处理的情况
 * </p>
 */
public class LinkedListV2<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListV2() {
        dummyHead = new Node();
        size = 0;
    }


    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }


    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }


    /**
     * 在链表头添加新的元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 在链表末尾添加新的元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }
}
