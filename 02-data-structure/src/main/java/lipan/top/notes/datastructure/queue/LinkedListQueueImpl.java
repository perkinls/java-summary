package lipan.top.notes.datastructure.queue;

import lipan.top.notes.datastructure.linkedlist.LinkedListV3;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 链表实现队列
 * @createTime 2021年05月21日 12:56:00
 * <p>
 *
 * </p>
 */
public class LinkedListQueueImpl<E> implements IQueue<E> {
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

    /**
     * 链表维护一个头和尾节点Node
     */
    private Node head, tail;
    private int size;

    public LinkedListQueueImpl() {
        head = null;
        tail = null;
        size = 0;
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
    public void enqueue(E e) {
        // head 1->2->3->null  tail
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node retNode = head;
        // head向后移动
        head = head.next;
        retNode.next = null;
        if(head == null)
            tail = null;
        size --;
        return retNode.e;
    }

    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
