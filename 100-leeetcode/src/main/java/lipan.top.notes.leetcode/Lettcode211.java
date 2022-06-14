package lipan.top.notes.leetcode;

import java.util.HashMap;

/**
 * @author li.pan
 * @title 添加与搜索单词 - 数据结构设计
 * @Date 2022/6/13
 * <p>
 * https://leetcode.cn/problems/design-add-and-search-words-data-structure/
 * </p>
 */
public class Lettcode211 {

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

    public Lettcode211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.next.get(c) == null)
                curNode.next.put(c, new Node());
            curNode = curNode.next.get(c);
        }
        curNode.isWord = true;
    }

    public boolean search(String word) {

        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length()) // 递归到底
            return node.isWord;

        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null)
                return false;
            return search(node.next.get(c), word, index + 1);
        } else {
            for (char next : node.next.keySet())
                if (search(node.next.get(next), word, index + 1))
                    return true;
            return false;
        }
    }


    public static void main(String[] args) {
        Lettcode211 lettcode211 = new Lettcode211();
        lettcode211.addWord("bad");
        lettcode211.addWord("dad");
        lettcode211.addWord("mad");
//        System.out.println(lettcode211.search("pad")); // 返回 False
//        System.out.println(lettcode211.search("bad")); // 返回 True
        System.out.println(lettcode211.search(".ad")); // 返回 True
        System.out.println(lettcode211.search("b..")); // 返回 True
    }
}
