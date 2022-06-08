package lipan.top.notes.leetcode;

import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.List;

/**
 * @author li.pan
 * @title 两数相加
 * @Date 2022/6/7
 * <p>
 * https://leetcode.cn/problems/add-two-numbers/
 * </p>
 */
public class Lettcode002 {

    public static class ListNode {
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

            String s = String.valueOf(val);
            while (next != null) {
                s = s + "->" + next.val;
                next=next.next;
            }

            return s;
        }
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        StringBuffer s1 = new StringBuffer();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        StringBuffer s2 = new StringBuffer();
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        StringBuilder accRes =
                new StringBuilder()
                        .append(Long.parseLong(String.valueOf(s1.reverse())) + Long.parseLong(String.valueOf(s2.reverse())));

        ListNode res = null;
        for (int i = 0; i < accRes.length(); i++)
            res = new ListNode(Integer.parseInt(String.valueOf(accRes.charAt(i))), res);

        return res;
    }

    /*
     * 官网答案
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, null);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));
        System.out.println(addTwoNumbers1(l1, l2));
    }

}
