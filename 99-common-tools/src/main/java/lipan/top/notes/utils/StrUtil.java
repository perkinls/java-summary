package lipan.top.notes.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 字符串处理
 * @createTime 2020年12月09日 20:18:00
 */
public class StrUtil {
    /**
     * 判断特殊字符
     * https://blog.csdn.net/you23hai45/article/details/20163459
     */
    public static String filterStr(String str) throws PatternSyntaxException {
        /**
         * 特殊字符
         */
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？_]";

        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);

        /**
         * 返回替换结果
         */
        return mat.replaceAll("").trim();
    }

    /**
     * 去除所有空格，制表，换行
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 字符串截取
     *
     * @param str
     * @param start  开始
     * @param length 长度
     * @return
     */
    public static final String substr(String str, Integer start, Integer length) {
        if (length > 0) {
            return str.substring(start, length);
        }
        return str.substring(start);
    }

    /**
     * 字符串长度
     * 中文2个字符，英文1个字符
     *
     * @param value
     * @return
     */
    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        for (int i = 0, j = value.length(); i < j; i++) {
            String temp = value.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }
}
