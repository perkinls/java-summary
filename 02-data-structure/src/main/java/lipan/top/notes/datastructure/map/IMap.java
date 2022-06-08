package lipan.top.notes.datastructure.map;

/**
 * @author li.pan
 * @title 映射接口
 */
public interface IMap<K, V> {
    /**
     * 添加元素
     *
     * @param key   键
     * @param value 值
     */
    void add(K key, V value);

    /**
     * 根据key删除元素
     *
     * @param key 键
     * @return 被删除的value
     */
    V remove(K key);

    /**
     * 根据key查询元素是否存在
     *
     * @param key key
     * @return boolean
     */
    boolean contains(K key);

    /**
     * 根据key获取value
     *
     * @param key key
     * @return value
     */
    V get(K key);

    /**
     * 改变key的value
     *
     * @param key   key
     * @param value value
     */
    void set(K key, V value);

    /**
     * 获取Map中的元素个数
     *
     * @return 元素个数
     */
    int getSize();

    /**
     * 判断Map是否为空
     *
     * @return boolean
     */
    boolean isEmpty();
}
