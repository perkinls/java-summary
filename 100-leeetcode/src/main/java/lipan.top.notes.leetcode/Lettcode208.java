package lipan.top.notes.leetcode;

import java.util.HashMap;

/**
 * @author li.pan
 * @title 实现 Lettcode208 (前缀树)
 * @Date 2022/6/13
 * <p>
 *     https://leetcode.cn/problems/implement-trie-prefix-tree/submissions/
 * </p>
 */
public class Lettcode208 {

    class Node {
        private boolean isWord;
        private HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    public Lettcode208() {
        root = new Node();
    }

    public void insert(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.next.get(c) == null)
                curNode.next.put(c, new Node());
            curNode = curNode.next.get(c);
        }

        if (!curNode.isWord)
            curNode.isWord = true;
    }

    public boolean search(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.next.get(c) == null)
                return false;
            curNode = curNode.next.get(c);
        }
        return curNode.isWord;
    }

    public boolean startsWith(String prefix) {

        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curNode.next.get(c) == null)
                return false;
            curNode = curNode.next.get(c);
        }
        return true;
    }
}
