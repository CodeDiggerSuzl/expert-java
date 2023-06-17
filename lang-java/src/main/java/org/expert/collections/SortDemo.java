package org.expert.collections;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class SortDemo {

    public static void main(String[] args) {
//        // final List<String> dateList = Lists.newArrayList("2023-01-01 15:12", "2022-01-01 17:12", "2022-01-01 11:12", "2022-12-01 22:12");
//        // Lists.newArrayList("1,2,3,21").stream().reduce((a, b) -> a + "," + b).ifPresent(System.out::println);
//        // ArrayList<String> dateList = Lists.newArrayList("1", "192", "3");
//        ArrayList<Integer> dateList = Lists.newArrayList(1, 2, 2, 33, 4);
//        Collections.sort(dateList);
//        System.out.println(dateList);
//        dateList.sort(Comparator.comparing(Function.identity()));
//        System.out.println(dateList);

        Date date2 = new Date(1673488800000L);
        System.out.println(date2);

        Date date = new Date();
        Date date1 = DateUtils.addDays(date, 1);
        long time = date.getTime();
        System.out.println(time);
        System.out.println(date1.getTime() - time);
    }


}
