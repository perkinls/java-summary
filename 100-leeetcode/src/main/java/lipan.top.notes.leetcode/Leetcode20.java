package lipan.top.notes.leetcode;

import java.util.Stack;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 力扣题
 * @createTime 2021年05月11日 20:45:00
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * </p>
 */
public class Leetcode20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

//    /**
//     * 巧用替换思想,中间必定成对出现。（数据量较大情况下性能较低）
//     * @param s
//     * @return
//     */
//    public boolean isValid(String s) {
//        int length = s.length() / 2;
//        for (int i = 0; i < length; i++) {
//            s = s.replace("()", "").replace("{}", "").replace("[]", "");
//        }
//
//        return s.length() == 0;
//    }
    public static void main(String[] args) {
//        System.out.println("input(),  result=" + new Leetcode22().isValid("()"));
//        System.out.println("input()[]{},  result=" + new Leetcode22().isValid("()[]{}"));
//        System.out.println("input()[){},  result=" + new Leetcode22().isValid("()[){}"));
//        System.out.println("input(],  result=" + new Leetcode22().isValid("(]"));
//        System.out.println("input([)],  result=" + new Leetcode22().isValid("([)]"));
//        System.out.println("input{[]},  result=" + new Leetcode22().isValid("{[]}"));
//        System.out.println("input(]),  result=" + new Leetcode22().isValid("(])"));

        System.out.println(4%5);

    }
}
