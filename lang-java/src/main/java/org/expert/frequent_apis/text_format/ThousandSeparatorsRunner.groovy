package org.expert.frequent_apis.text_format

class ThousandSeparatorsRunner {
    static void main(String[] args) {
        println(ThousandsSeparators.usingStringFormat(1))
        println(ThousandsSeparators.usingDecimalFormat("¤¤ ,###.##", 1100.3D))

        println(ThousandsSeparators.numberFormat(Locale.SIMPLIFIED_CHINESE, 1111.33D))

        // 两个 ¤¤ shows: USD CNY
        // 一个 ¤ shows: $ ￥
        println(ThousandsSeparators.specificFormat(Locale.US, "¤ ,###.##", 11111.333D))
        println(ThousandsSeparators.specificFormat(Locale.SIMPLIFIED_CHINESE, "¤ ,###.##", 11111.333D))
        println(ThousandsSeparators.specificFormat(Locale.GERMANY, "¤ ,###.##", 11111.333D))


        println(ThousandsSeparators.specificFormat2(Locale.US, "¤¤ ,###.##", 11111.333D))
        println(ThousandsSeparators.specificFormat2(Locale.SIMPLIFIED_CHINESE, "¤¤ ,###.##", 11111.333D))
        println(ThousandsSeparators.specificFormat2(Locale.GERMANY, "¤¤ ,###.##", 11111.333D))
    }
}