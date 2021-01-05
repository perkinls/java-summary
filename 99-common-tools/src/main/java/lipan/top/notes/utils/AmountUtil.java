package lipan.top.notes.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 金额元与分转换转换工具类
 * @createTime 2020年12月09日 19:32:00
 */
public class AmountUtil {

    /**
     * 金额为分的格式
     */
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

    /**
     * 将分为单位的转换为元并返回金额格式的字符串 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(Long amount) throws Exception {
        if (!amount.toString().matches(CURRENCY_FEN_REGEX)) {
            throw new Exception("金额格式有误");
        }

        int flag = 0;
        String amString = amount.toString();
        if (amString.charAt(0) == '-') {
            flag = 1;
            amString = amString.substring(1);
        }
        StringBuffer result = new StringBuffer();
        if (amString.length() == 1) {
            result.append("0.0").append(amString);
        } else if (amString.length() == 2) {
            result.append("0.").append(amString);
        } else {
            String intString = amString.substring(0, amString.length() - 2);
            for (int i = 1; i <= intString.length(); i++) {
                if ((i - 1) % 3 == 0 && i != 1) {
                    result.append(",");
                }
                result.append(intString.substring(intString.length() - i, intString.length() - i + 1));
            }
            result.reverse().append(".").append(amString.substring(amString.length() - 2));
        }
        if (flag == 1) {
            return "-" + result.toString();
        } else {
            return result.toString();
        }
    }

    /**
     * 将分为单位的转换为元 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(String amount) throws Exception {
        if (!amount.matches(CURRENCY_FEN_REGEX)) {
            throw new Exception("金额格式有误");
        }
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount
     * @return
     */
    public static String changeY2F(Long amount) {
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
     *
     * @param amount
     * @return
     */
    public static String changeY2F(String amount) {
        String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if (index == -1) {
            amLong = Long.valueOf(currency + "00");
        } else if (length - index >= 3) {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        } else if (length - index == 2) {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        } else {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }

    /**
     * 分转元（保留两位有效数字）
     *
     * @param amount
     * @return
     */
    public static String centToYuan(String amount) {
        DecimalFormat df = new DecimalFormat("######0.00");
        Double d = Double.parseDouble(amount) / 100;
        return df.format(d).toString();
    }

    /**
     * 元转分
     *
     * @param amount
     * @return
     */
    public static String yuanToCent(String amount) {
        DecimalFormat df = new DecimalFormat("######0");
        Double d = Double.parseDouble(amount) * 100;
        return df.format(d).toString();
    }

    /**
     * 指定国际钱币符号
     *
     * @param locale
     * @return
     */
    public static String getCurrencySymbol(java.util.Locale locale) {
        Currency currency = Currency.getInstance(locale);
        return currency.getSymbol();
    }

    /**
     * 指定国际钱币代码 例如 CNY
     *
     * @param locale
     * @return
     */
    public static String getCurrencyCode(java.util.Locale locale) {
        Currency currency = Currency.getInstance(locale);
        return currency.getCurrencyCode();
    }

    /**
     * 指定国际钱币代码 例如 147
     *
     * @param locale
     * @return
     */
    public static Integer getCurrencyInt(java.util.Locale locale) {
        Currency currency = Currency.getInstance(locale);
        return currency.getNumericCode();
    }


}
