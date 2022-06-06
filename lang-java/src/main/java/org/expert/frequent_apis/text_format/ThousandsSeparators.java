package org.expert.frequent_apis.text_format;


/**
 * thousands-separators
 * <p>
 * 金额或者数字按照千分位用 , 分割的几种实现方式
 *
 * @author suzailong
 * @date 2022/6/6-6:38 下午
 */
public class ThousandsSeparators {

    public static String usingStringFormat(int num) {
        return String.format("%,d", num);
    }
}
