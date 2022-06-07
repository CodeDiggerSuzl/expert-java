package org.expert.creational.builder_pattern.demo_1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 套餐
 * <p>
 * 角色 套餐
 *
 * @author suzailong
 * @date 2022/6/7-5:03 PM
 */
@Getter
@Setter
@ToString
public class MealSet {

    private String mainFood;

    private String drink;

    private String bottleSize;

    private String dessert;


}
