package lipan.top.notes.datastructure.set;

/**
 * @author li.pan
 * @title 集合接口
 */
public interface ISet<E> {
    /**
     * 添加元素
     *
     * @param e e
     */
    void add(E e);

    /**
     * 删除元素
     *
     * @param e e
     */
    void remove(E e);

    /**
     * 是否包含指定元素
     *
     * @param e e
     * @return boolean
     */
    boolean contains(E e);

    /**
     * 获取集合中的元素个数
     *
     * @return int
     */
    int getSize();

    /**
     * 集合是否为空
     *
     * @return boolean
     */
    boolean isEmpty();
}
