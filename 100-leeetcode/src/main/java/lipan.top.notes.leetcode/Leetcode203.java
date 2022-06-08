package lipan.top.notes.leetcode;


/**
 * @author li.pan
 * @version 1.0.0
 * @title 力扣题
 * @createTime 2021年05月11日 20:45:00
 * <p>
 *
 * </p>
 */
public class Leetcode203 {

    /**
     * 删除链表中的元素
     *
     * @param head 链表
     * @param val  元素
     * @return
     */
    public ListNode removeElementsV1(ListNode head, int val) {

        // 没有虚拟头节点情况下
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null)
            return head;

        // 删除节点需要找到链表中的前一个节点 pre始终保持前一个节点
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else
                prev = prev.next;
        }


        return head;
    }

    /**
     * 删除链表中的元素（使用虚拟头节点）
     *
     * @param head 链表
     * @param val  元素
     * @return
     */
    public ListNode removeElementsV2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 删除节点需要找到链表中的前一个节点 pre始终保持前一个节点
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else
                prev = prev.next;
        }


        return dummyNode.next;
    }


    /**
     * 递归删除链表中的元素
     *
     * @param head 链表
     * @param val  元素
     * @return
     */
    public ListNode removeElementsV3(ListNode head, int val) {

        if (head == null)
            return null;
        ListNode res = removeElementsV3(head.next, val);
        if (head.val == val) { // 当前节点等于固定值,链表跳过当前节点
            return res;
        } else {
            head.next = res;
            return head;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    public static void main(String[] args) {
        ListNode head
                = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        ListNode node1 = new Leetcode203().removeElementsV1(head, 6);
        ListNode node2 = new Leetcode203().removeElementsV2(head, 6);

        System.out.println("Version 1 Input:[1,2,6,3,4,5,6],Output:" + nodeString(node1));
        System.out.println("Version 2 Input:[1,2,6,3,4,5,6],Output:" + nodeString(node2));


    }


    private static String nodeString(ListNode node) {
        StringBuilder res = new StringBuilder();

        ListNode cur = node;
        res.append("[");
        while (cur != null) {
            res.append(cur + ",");
            cur = cur.next;
        }

        return res.toString().substring(0, res.toString().lastIndexOf(",")) + "]";
    }
}
