package lipan.top.notes.datastructure.queue;

import lipan.top.notes.datastructure.heap.MaxHeap;

/**
 * @author li.pan
 * @title 基于堆实现优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements IQueue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }
}
