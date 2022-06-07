package org.expert.frequent_apis.text_format;


import cn.hutool.core.util.NumberUtil;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * thousands-separators
 * <p>
 * 金额或者数字按照千分位用 , 分割的几种实现方式
 *
 * @author suzailong
 * @date 2022/6/6-6:38 下午
 */
public class ThousandsSeparators {

    /**
     * 使用 string format 进行格式化
     * <p>
     * 似乎只能传入 int 然后使用 %,d 进行格式化, d 表示 decimal integer
     */
    public static String usingStringFormat(int num) {
        return String.format("%,d", num);
    }

    /**
     * Ref link: <a href="https://docs.oracle.com/javase/tutorial/java/data/numberformat.html">ref link</a>
     * <p>
     * 通过这种方式可以避免 "string + 单位" 的这种写法
     * <p>
     * <a href="https://raw.githubusercontent.com/CodeDiggerSuzl/pic-home/main/picgo/20220607110132.png">解释的图片</a>
     *
     * @param format format by this form
     * @param val    input value
     * @return formatted string
     */
    public static String usingDecimalFormat(String format, double val) {
        // ! DecimalFormat 用的 Locale 永远是 default
        final DecimalFormat decimalFormat = new DecimalFormat(format);
        // 其他具体的用法可以看这个方法的文档 doc 写的很清楚
        return decimalFormat.format(val);
    }

    /**
     * Number format 虽然能指定 locale,但是 format 方法都是用的这个地区默认的 format 方法
     * <p>
     * 想要指定特定 locale 和 format 可以用下面的两个方法
     *
     *
     * <a href="https://stackoverflow.com/questions/36418901/change-decimalformat-locale">ref link</a>
     */
    public static String numberFormat(Locale locale, double val) {
        final NumberFormat instance = NumberFormat.getNumberInstance(locale);
        return instance.format(val);
    }

    /**
     * 方法1 使用 DecimalFormatSymbols
     */
    static String specificFormat(Locale locale, String format, double val) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        DecimalFormat df = new DecimalFormat(format, symbols);
        return df.format(val);
    }

    /**
     * 方法 2 强制转换成子类
     * <blockquote>
     * <table border=0 cellspacing=3 cellpadding=0 summary="Chart showing symbol, location, localized, and meaning.">
     * <tr style="background-color: rgb(204, 204, 255);">
     * <th align=left>Symbol
     * <th align=left>Location
     * <th align=left>Localized?
     * <th align=left>Meaning
     * <tr valign=top>
     * <td><code>0</code>
     * <td>Number
     * <td>Yes
     * <td>Digit
     * <tr style="vertical-align: top; background-color: rgb(238, 238, 255);">
     * <td><code>#</code>
     * <td>Number
     * <td>Yes
     * <td>Digit, zero shows as absent
     * <tr valign=top>
     * <td><code>.</code>
     * <td>Number
     * <td>Yes
     * <td>Decimal separator or monetary decimal separator
     * <tr style="vertical-align: top; background-color: rgb(238, 238, 255);">
     * <td><code>-</code>
     * <td>Number
     * <td>Yes
     * <td>Minus sign
     * <tr valign=top>
     * <td><code>,</code>
     * <td>Number
     * <td>Yes
     * <td> Grouping separator
     * <tr style="vertical-align: top; background-color: rgb(238, 238, 255);">
     * <td><code>E</code>
     * <td>Number
     * <td>Yes
     * <td>Separates mantissa and exponent in scientific notation.
     * <em>Need not be quoted in prefix or suffix.</em>
     * <tr valign=top>
     * <td><code>;</code>
     * <td>Subpattern boundary
     * <td>Yes
     * <td>Separates positive and negative subpatterns
     * <tr style="vertical-align: top; background-color: rgb(238, 238, 255);">
     * <td><code>%</code>
     * <td>Prefix or suffix
     * <td>Yes
     * <td>Multiply by 100 and show as percentage
     * <tr valign=top>
     * <td><code>&#92;u2030</code>
     * <td>Prefix or suffix
     * <td>Yes
     * <td>Multiply by 1000 and show as per mille value
     * <tr style="vertical-align: top; background-color: rgb(238, 238, 255);">
     * <td><code>&#164;</code> (<code>&#92;u00A4</code>)
     * <td>Prefix or suffix
     * <td>No
     * <td> Currency sign, replaced by currency symbol.  If
     * doubled, replaced by international currency symbol. If present in a pattern, the monetary decimal separator is
     * used instead of the decimal separator.
     * <tr valign=top>
     * <td><code>'</code>
     * <td>Prefix or suffix
     * <td>No
     * <td>Used to quote special characters in a prefix or suffix,
     * for example, <code>"'#'#"</code> formats 123 to
     * <code>"#123"</code>.  To create a single quote
     * itself, use two in a row: <code>"# o''clock"</code>.
     * </table>
     * </blockquote>
     */
    public static String specificFormat2(Locale locale, String format, double val) {
        final NumberFormat nf = NumberFormat.getNumberInstance(locale);
        DecimalFormat formatter = (DecimalFormat) nf;
        formatter.applyPattern(format);
        return formatter.format(val);
    }

    /**
     * <a
     * href="https://hutool.cn/docs/#/core/%E5%B7%A5%E5%85%B7%E7%B1%BB/%E6%95%B0%E5%AD%97%E5%B7%A5%E5%85%B7-NumberUtil?id=decimalformat">hutool
     * doc link</a>
     * <p></p>
     * <a href="https://blog.csdn.net/evangel_z/article/details/7624503">Java DecimalFormat doc</a>
     */
    public static String usingHutool(String format, long val) {
        return NumberUtil.decimalFormat(format, val);
    }
}
