package lipan.top.notes.datastructure.set;


import lipan.top.notes.datastructure.tree.BinarySearchTree;

/**
 * @author li.pan
 * @title 基于二分搜索树实现的集合
 */
public class TreeSet<E extends Comparable<E>> implements ISet<E> {

    private final BinarySearchTree<E> bst;

    public TreeSet() {
        this.bst = new BinarySearchTree<E>();
    }

    @Override
    public void add(E e) {
        bst.addV2(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
       return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
