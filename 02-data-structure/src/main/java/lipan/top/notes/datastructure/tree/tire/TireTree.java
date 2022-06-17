package lipan.top.notes.datastructure.tree.tire;

import java.util.TreeMap;

/**
 * @author li.pan
 * @title 字典树
 * @Date 2022/6/14
 */
public class TireTree {
    class Node {
        /* 是否标记为单词 */
        public boolean isWord;
        /* 表示每一层的单词种类(可通过多种方式实现) */
        public TreeMap<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public TireTree() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得Trie中存储的单词数量
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     * @param word
     */
    public void add(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie中
     * @param word 单词
     * @return
     */
    public boolean contains(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }


    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix 前缀
     * @return
     */
    public boolean isPrefix(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }
}
