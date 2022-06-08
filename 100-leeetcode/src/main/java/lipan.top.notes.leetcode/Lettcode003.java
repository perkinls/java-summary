package lipan.top.notes.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author li.pan
 * @title 无重复字符的最长子串
 * @Date 2022/6/8
 */
public class Lettcode003 {
    public static int lengthOfLongestSubstring(String s) {
        // 字符 + 下标
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            // 计算最大值
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }

    public static void main(String[] args) {
        // 结合测试案列分析
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "dvdf";

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
    }
}
