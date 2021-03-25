package lipan.top.notes.interview;

import java.util.Scanner;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 约德尔测试
 * 兰博和提莫闲聊之后，回归到了他们的正题，约德尔人的未来。
 * 说起约德尔人的未来，黑默丁格曾经提出了一个约德尔测试，将约德尔人的历史的每个阶段都用一个字符表达出来。(包括可写字符,不包括空格。)。
 * 然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，这个字符变为1,其它变为0。
 * 然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。相似率越高,则约德尔的未来越光明。
 * 请问:相似率为多少？
 * @createTime 2021年01月26日 21:15:00
 */
public class YueDeErTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入历史history");
        String history = sc.nextLine();

        System.out.println("输入预测：look");
        String look = sc.nextLine();

        String a = "";

        //计算重复率
        int same = 0;
        //把字符转化为1,0；
        for (int i = 0; i < history.length(); i++) {
            char c = history.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                a = a + "1";
            } else {
                a = a + "0";
            }

            if (c == look.charAt(i)) {
                same++;
            }
        }
        System.out.println(a);
        System.out.println(same);

        float f = (float) same * 100 / (float) history.length();
        System.out.printf("相似率为：" + "%.2f%%", f);
    }
}


