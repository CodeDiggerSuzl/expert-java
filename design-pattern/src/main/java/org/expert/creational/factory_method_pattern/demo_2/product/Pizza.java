package org.expert.creational.factory_method_pattern.demo_2.product;

import lombok.Getter;
import lombok.Setter;

/**
 * 公共类
 *
 * @author suzailong
 * @date 2022/6/7-11:59 PM
 */
@Getter
@Setter
public class Pizza {
    public Pizza() {
    }

    public Pizza(String name) {
        this.name = name;
    }

    private String name;

    public void prepare() {
        System.out.println("preparing pizza");
    }

    public void bake() {
        System.out.println("baking pizza");
    }

    public void slice() {
        System.out.println("slicing pizza");
    }

    public void box() {
        System.out.println("boxing pizza");
    }

}
