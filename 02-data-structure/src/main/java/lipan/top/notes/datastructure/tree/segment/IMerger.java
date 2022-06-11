package lipan.top.notes.datastructure.tree.segment;

/**
 * @author li.pan
 * @title 线段树 结合规律
 * @Date 2022/6/8
 */
interface IMerger<E> {
    E merge(E a, E b);
}
