package lipan.top.notes.datastructure.stack;

import lipan.top.notes.datastructure.array.UdfArrayV2;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 使用<< 自定义动态数组数组>>实现栈
 * @createTime 2020年12月09日 13:28:00
 */
public class ArrayStackImpl<E> implements IStack<E> {

    private UdfArrayV2<E> array;

    public ArrayStackImpl(int capacity) {
        array = new UdfArrayV2<E>(capacity);
    }

    public ArrayStackImpl() {
        array = new UdfArrayV2<>();
    }

    /**
     * 获取栈中元素的个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入栈，只需要调用自定义数组的向最后位置添加元素的方法即可
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 弹栈，只需删除最后一个元素
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看元素，只需要查看栈顶元素，也就是数组中的最后一个元素
     *
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(",");
        }
        res.append("] top");

        return res.toString();
    }

}
