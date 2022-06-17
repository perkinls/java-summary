package lipan.top.notes.datastructure.tree.unionfind;

/**
 * 并查集java接口
 */
public interface UF {

    /**
     * 数据容积
     * @return
     */
    int getSize();

    /**
     * 是否连接
     * @param p 元素p
     * @param q 元素q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 连接两个元素
     * @param p 元素p
     * @param q 元素q
     */
    void unionElements(int p, int q);
}
