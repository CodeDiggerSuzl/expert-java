package org.expert.collections;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<String> couponSetIdList = Lists.newArrayList("1|2", "3|21", "1|2", "3|21");

        Set<String> uniqueCouponSetIdList = couponSetIdList.stream().flatMap(s -> Arrays.stream(s.split("\\|"))).collect(Collectors.toSet());

        System.out.println(uniqueCouponSetIdList);
        String allUniqueCouponSetStr = String.join("|", uniqueCouponSetIdList);

        System.out.println((allUniqueCouponSetStr));
    }
}
