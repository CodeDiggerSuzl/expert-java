package org.expert.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.expert.JsonUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class SortDemo {
    @Data
    @AllArgsConstructor
    static class Coupon {

        private Long id;

        private String name;

        private String price;

        private String desc;

        private String available;
    }

    /*--------------------------------------------------------------------------------------------------------------*/
    private void getSortedCouponInfos(List<Coupon> driverCouponList) {
        driverCouponList.sort((o1, o2) -> {
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
    //    @Test
    //    public void test() {
    //        Coupon c1 = new Coupon("1元即将过期可用", "1", "过期", "1");
    //        Coupon c2 = new Coupon("2元即将过期可用", "2", "过期", "1");
    //        Coupon c3 = new Coupon("3元非即将过期可用", "3", "-", "1");
    //        Coupon c4 = new Coupon("5元非即将过期可用", "5", "-", "1");
    //        Coupon c5 = new Coupon("5元非即将过期不可用", "5", "-", "0");
    //        Coupon c6 = new Coupon("3元即将过期不可用", "3", "过期", "0");
    //        Coupon c7 = new Coupon("6元即将过期不可用", "6", "过期", "0");
    //        Coupon c8 = new Coupon("1元非即将过期不可用", "1", "-", "0");
    //
    //
    //        ArrayList<Coupon> coupons = Lists.newArrayList(c1, c2, c3, c5, c4, c6, c7, c8);
    //        getSortedCouponInfos(coupons);
    //        coupons.sort(Comparator.comparing(Coupon::getAvailable).reversed());
    //
    //        System.out.println("JsonUtil.toJson(coupons) = " + JsonUtil.toJson(coupons));
    //
    //        System.out.println("coupons.stream().map(Coupon::getName).collect(Collectors.toList()) = " + coupons.stream().map(Coupon::getName).collect(Collectors.toList()));
    //    }


    @Test
    public void testByPrice() {
        Coupon c1 = new Coupon(101L, "1元即将过期可用", "1", "过期", "1");
        Coupon c2 = new Coupon(89L, "2元即将过期可用", "12", "过期", "1");
        Coupon c3 = new Coupon(29L, "3元非即将过期可用", "3", "-", "1");
        ArrayList<Coupon> list = Lists.newArrayList(c1, c2, c3);
        //        list.sort(Comparator.comparing(t -> new BigDecimal(t.getPrice()), Comparator.reverseOrder()));
        //        System.out.println("JsonUtil.toJson(coupons) = " + JsonUtil.toJson(list));


        //        Coupon coupon = list.stream().filter(a -> a.getPrice() == null).min(Comparator.comparing(Coupon::getAvailable))
        //                .orElseGet(null);
        List<Coupon> collect = list.stream().sorted(Comparator.comparing(Coupon::getId).reversed()).collect(Collectors.toList());
        System.out.println("collect = " + JsonUtil.toJson(collect));

    }

    @Test
    public void testNum() {
        List<Integer> list = Lists.newArrayList(1, 2, 44, 4);

    }

    @Test
    public void test_1() {

        String s = "%s返利最高可返%s元";
        String format = String.format(s, "10" + "%", "300");
        System.out.println("format = " + format);

        List<String> defList = com.google.common.collect.Lists.newArrayList("home_bottom", "home_bottom_carpool", "home_bottom_taxi");

        System.out.println("JsonUtil.toJson(defList) = " + JsonUtil.toJson(defList));
    }

    @Test
    public void testRetainAll() {
        ArrayList<String> a = Lists.newArrayList("Ad1", "Ad4", "Ad7");
        ArrayList<String> b = Lists.newArrayList("Ad2", "Ad1");
        boolean b1 = b.retainAll(a);
        System.out.println("b1 = " + b1);

        System.out.println("b = " + b);

    }

    @Test
    public void test_eq() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("运营部-广告销售部-广告销售组", 7);
        map.put("产品与发展部-顺风车业务部-顺风车运营组", 2);
        map.put("产品与发展部-用户增长部", 1);
        map.put("市场推广部-项目组", 5);
        map.put("运营部-客服部-客服组", 6);
        map.put("运营部-城市运营部", 4);
        map.put("产品与发展部-出租车业务部-出租车运营组", 3);
        System.out.println("ma = " + JsonUtil.toJson(map));

    }

}
