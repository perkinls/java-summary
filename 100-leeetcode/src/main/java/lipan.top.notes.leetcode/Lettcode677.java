package lipan.top.notes.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li.pan
 * @title 键值映射
 * @Date 2022/6/14
 * <p>
 *  https://leetcode.cn/problems/map-sum-pairs/
 * </p>
 */
public class Lettcode677 {
    class Node {
        int value;
        Map<Character, Node> next;

        public Node(int value) {
            this.value = value;
            this.next = new HashMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    public Lettcode677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node curNode = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (curNode.next.get(c) == null) {
                curNode.next.put(c, new Node());
            }
            curNode = curNode.next.get(c);
        }
        curNode.value = val;
    }

    public int sum(String prefix) {
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curNode.next.get(c) == null)
                return 0;
            curNode = curNode.next.get(c);
        }

        return sum(curNode);
    }

    private int sum(Node node) {
        int res = node.value;
        for (char next : node.next.keySet())
            res += sum(node.next.get(next));
        return res;
    }

    public static void main(String[] args) {
        Lettcode677 mapSum = new Lettcode677();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // 返回 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // 返回 5 (apple + app = 3 + 2 = 5)

    }
}
