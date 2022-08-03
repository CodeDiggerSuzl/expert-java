import org.junit.Test;

/**
 * @author suzailong
 * @date 2022/6/14-6:03 PM
 */
public class DailyTest {
    public static void main(String[] args) {
        String str = " 200";
        // replace space of str
        // str = str.replaceAll("\\s+", "");
        // System.out.println(str);
        // System.out.println("Long.parseLong(str) = " + Long.parseLong(str));
        // System.out.println("Integer.parseInt(str) = " + Integer.parseInt(str));

        // remove while
        // List<String> list = new ArrayList<>();
        // list.add("1");
        // list.add("2");
        // for (String item : list) {
        //     if ("2".equals(item)) {
        //         list.remove(item);
        //     }
        // }


    }


    @Test
    public void unboxingTest() {
        // Integer 相乘后会拆箱成 int
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        int cal = a * b; // return type is int, primitive type
        boolean flag = false;
        System.out.println(flag ? a * b : c); // throws npe,cause a*b return an int type.
    }

}
