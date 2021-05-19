package lipan.top.notes.datastructure.queue;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 队列接口
 * @createTime 2021年05月11日 20:54:00
 */
public interface IQueue<E> {
    /**
     * 获取队列中的元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队列
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E dequeue();

    /**
     * 查看队首元素
     *
     * @return
     */
    E getFront();
}
