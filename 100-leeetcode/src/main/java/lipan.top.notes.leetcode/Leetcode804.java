package lipan.top.notes.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li.pan
 * @title 804.唯一摩尔斯密码词
 */
public class Leetcode804 {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] bosPasswords = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder convertBos = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                convertBos.append(bosPasswords[word.charAt(i) - 'a']);
            }
            //System.out.println(convertBos.toString());
            res.add(convertBos.toString());
        }
        return res.size();
    }


    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
