package org.expert.entity;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * @author suzailong
 * @date 2022/6/16-5:20 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private Integer age;


    public List<User> getRandomUsers() {
        final int rand = RandomUtils.nextInt(1, 5);
        final List<User> randList = Lists.newArrayListWithCapacity(rand);
        for (int i = 0; i < rand; i++) {
            randList.add(new User(RandomUtil.randomString(5), RandomUtil.randomInt(1, 100)));
        }
        return randList;
    }

}