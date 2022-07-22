package org.expert.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author suzailong
 * @date 2022/6/16-5:33 PM
 */
public class CollectionUtilTest {


    private final List<Integer> steadyList = Lists.newArrayList(1, 13, 4, 5, 19);

    List<Integer> genRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(RandomUtils.nextInt(0, 10));
        }
        return list;
    }

    @Test
    public void listBsSearchTest() {
        Collections.shuffle(steadyList);
        System.out.println(steadyList);
        final int idx = Collections.binarySearch(steadyList, 5);
        System.out.println("Collections.binarySearch(steadyList, 5) = " + idx);
    }

    @SuppressWarnings("unchecked")
    @Test // 交集并集差集操作
    public void twoListOpsTest() {
        final List<Integer> randList = genRandomList(5);
        System.out.println("randList = " + randList);
        System.out.println("steadyList = " + steadyList);
        System.out.println("---".repeat(10));
        // 并集
        final Collection<Integer> unionList = CollectionUtils.union(randList, steadyList);
        System.out.println("unionList = " + unionList);

        //获取交集
        Collection<Integer> intersectionList = CollectionUtils.intersection(randList, steadyList);
        System.out.println("intersectionList = " + intersectionList);

        //获取交集的补集
        Collection<Integer> disjunctionList = CollectionUtils.disjunction(randList, steadyList);
        System.out.println("disjunctionList = " + disjunctionList);

        //获取差集
        Collection<Integer> subtractList = CollectionUtils.subtract(randList, steadyList);
        System.out.println("subtractList = " + subtractList);
    }


}
