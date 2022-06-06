package org.expert.frequent_apis.text_format

import spock.lang.Specification
import spock.lang.Unroll


/**
 * ${DESC}*
 * @author suzailong* @date 2022/6/6-11:08 下午
 */
class ThousandsSeparatorsTest extends Specification {
    @Unroll
    def "formatThousand, using String.format() method. input:[#input] --> output:[#expect]"() {
        expect: "find result"
        ThousandsSeparators.usingStringFormat(input) == expect

        where: "result"
        input || expect
        0     || "0"
        100   || "100"
        1000  || "1,000"
        -1    || "-1"
        10001 || "10,001"
    }



}
