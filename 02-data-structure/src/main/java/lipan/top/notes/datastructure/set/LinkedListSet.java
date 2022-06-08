package lipan.top.notes.datastructure.set;

import lipan.top.notes.datastructure.linkedlist.LinkedListV3;

/**
 * @author li.pan
 * @title 基于链表实现的集合
 */
public class LinkedListSet<E> implements ISet<E> {

    private final LinkedListV3<E> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedListV3<E>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e))
            linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
