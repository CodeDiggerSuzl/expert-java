package org.expert.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.expert.JsonUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class SortDemo {
    @Data
    @AllArgsConstructor
    static class Coupon {

        private String name;

        private String price;

        private String desc;

        private String available;
    }

    /*--------------------------------------------------------------------------------------------------------------*/
    private void getSortedCouponInfos(List<Coupon> driverCouponList) {
        Collections.sort(driverCouponList, (o1, o2) -> {
            BigDecimal o1Price = new BigDecimal(o1.getPrice());
            BigDecimal o2Price = new BigDecimal(o2.getPrice());
            if (o1.getDesc().contains("过期") && o2.getDesc().contains("过期")) {
                return Integer.compare(o2Price.compareTo(o1Price), 0);
            }
            if (o1.getDesc().contains("过期")) {
                return -1;
            }
            if (o2.getDesc().contains("过期")) {
                return 1;
            }
            return Integer.compare(o2Price.compareTo(o1Price), 0);
        });
    }

    /*--------------------------------------------------------------------------------------------------------------*/
    @Test
    public void test() {
        Coupon c1 = new Coupon("1元即将过期可用", "1", "过期", "1");
        Coupon c2 = new Coupon("2元即将过期可用", "2", "过期", "1");
        Coupon c3 = new Coupon("3元非即将过期可用", "3", "-", "1");
        Coupon c4 = new Coupon("5元非即将过期可用", "5", "-", "1");
        Coupon c5 = new Coupon("5元非即将过期不可用", "5", "-", "0");
        Coupon c6 = new Coupon("3元即将过期不可用", "3", "过期", "0");
        Coupon c7 = new Coupon("6元即将过期不可用", "6", "过期", "0");
        Coupon c8 = new Coupon("1元非即将过期不可用", "1", "-", "0");


        ArrayList<Coupon> coupons = Lists.newArrayList(c1, c2, c3, c5, c4, c6, c7, c8);
        getSortedCouponInfos(coupons);
        coupons.sort(Comparator.comparing(Coupon::getAvailable).reversed());

        System.out.println("JsonUtil.toJson(coupons) = " + JsonUtil.toJson(coupons));

        System.out.println("coupons.stream().map(Coupon::getName).collect(Collectors.toList()) = " + coupons.stream().map(Coupon::getName).collect(Collectors.toList()));
    }
}
