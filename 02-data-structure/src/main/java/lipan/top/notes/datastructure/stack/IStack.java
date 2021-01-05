package lipan.top.notes.datastructure.stack;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 自定义栈
 * @createTime 2020年12月09日 13:25:00
 */
public interface IStack<E> {

    /**
     * 获取栈中元素的个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();
}
