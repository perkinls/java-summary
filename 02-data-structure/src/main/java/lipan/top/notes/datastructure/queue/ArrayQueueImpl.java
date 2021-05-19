package lipan.top.notes.datastructure.queue;

import lipan.top.notes.datastructure.array.UdfArrayV2;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 基于Array实现Queue
 * @createTime 2021年05月11日 20:57:00
 */
public class ArrayQueueImpl<E> implements IQueue<E> {
    private UdfArrayV2<E> array;

    public ArrayQueueImpl(int capacity) {
        array = new UdfArrayV2<>(capacity);
    }

    public ArrayQueueImpl() {
        array = new UdfArrayV2<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueueImpl<Integer> queue = new ArrayQueueImpl<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("移除后" + queue);
            }
        }
    }

}
