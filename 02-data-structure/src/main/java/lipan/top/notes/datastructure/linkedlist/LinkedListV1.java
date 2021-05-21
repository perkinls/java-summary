package lipan.top.notes.datastructure.linkedlist;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 链表基本实现v1版本
 * @createTime 2021年05月20日 14:11:00
 * <p>
 * 链表是真正的动态数据结构，不需要处理动态容量问题和提前开辟空间
 * </p>
 */
public class LinkedListV1<E> {

    /**
     * 构造链表的Node数据结构（内部类）
     */
    private class Node {
        //变量值
        public E e;
        //指向当前节点的下一个节点   最后一个节点的next为null
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

    /**
     * 链表头
     */
    private Node head;
    private int size;

    public LinkedListV1() {
        head = null;
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
     * 在链表头添加新的元素e
     *
     * @param e
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;    //头节点向前偏移

        //等同于上面三行
        head = new Node(e, head);
        size++;
    }

    /**
     * 在链表中间添加元素
     * <p>
     * 关键：找到要添加的节点的前一个节点
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if (index == 0)
            addFirst(e);
        else {
            //前一个节点，从head开始
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;

            //逻辑顺序不能变
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);
            size++;
        }
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
