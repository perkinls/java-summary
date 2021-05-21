package lipan.top.notes.datastructure.stack;

import lipan.top.notes.datastructure.linkedlist.LinkedListV3;
import lipan.top.notes.datastructure.stack.IStack;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 基于自定义链表实现<< 栈>>
 * @createTime 2021年05月21日 10:48:00
 * <p>
 *
 * </p>
 */
public class LinkedListStackImpl<E> implements IStack<E> {

    private LinkedListV3<E> list;

    public LinkedListStackImpl() {
        list = new LinkedListV3<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

}
