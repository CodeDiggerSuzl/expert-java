package org.expert.collections;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

public class SortDemo {

    public static void main(String[] args) {
        // final List<String> dateList = Lists.newArrayList("2023-01-01 15:12", "2022-01-01 17:12", "2022-01-01 11:12", "2022-12-01 22:12");
        // Lists.newArrayList("1,2,3,21").stream().reduce((a, b) -> a + "," + b).ifPresent(System.out::println);
        ArrayList<String> dateList = Lists.newArrayList("1", "192", "3");
        Collections.sort(dateList);
        System.out.println(dateList);
        dateList.sort(Comparator.comparing(Function.identity()));
        System.out.println(dateList);
    }


}
