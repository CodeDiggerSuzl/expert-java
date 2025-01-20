import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 *
 */
@Slf4j
public class Main {

    @Test
    public void test() {
        // 创建测试数据
        // List<Entity> a = new ArrayList<>();
        // a.add(new Entity(3, "Entity_3"));
        // a.add(new Entity(null, "Entity_Null"));
        // a.add(new Entity(1, "Entity_4"));
        // a.add(new Entity(1, "Entity_2"));
        //
        // // 按照要求排序：id 越大越靠前，如果 id 为 null，则排在最后
        // a.sort(Comparator.comparing(Entity::getId, Comparator.nullsLast(Comparator.naturalOrder())).thenComparing(Entity::getName));
        //
        // // 输出排序结果
        // a.forEach(System.out::println);
        String s = "2088942897798973";
        String tableFullName = getTableName("act_pending_record", s);
        System.out.println("tableFullName = " + tableFullName);

        System.out.println("getTableName2 = " + getTableName2("act_pending_record", s));
    }

    public static String getTableName(String tableName, String thirdUserId) {
        if (StringUtils.isEmpty(tableName)) {
            throw new RuntimeException("未获取到表名,无法分表");
        }
        if (thirdUserId == null) {
            throw new RuntimeException("表名:[" + tableName + "],未传入user id,无法分表!!");
        }
        int hashCode = thirdUserId.hashCode();
        System.out.println("hashCode = " + hashCode);
        int idx = hashCode == Integer.MIN_VALUE ? 0 : Math.abs(hashCode % 16);
        return tableName + "_" + idx;
    }


    public static String getTableName2(String tableName, String thirdUserId) {
        if (StringUtils.isEmpty(tableName)) {
            throw new RuntimeException("未获取到表名,无法分表");
        }
        if (thirdUserId == null) {
            throw new RuntimeException("表名:[" + tableName + "],未传入user id,无法分表!!");
        }
        return tableName + "_" + (thirdUserId.hashCode() % 16);
    }

    @Data
    @AllArgsConstructor
    class Entity {
        private Integer id; // id 可能为 null
        private String name; // 其他属性

    }
}
