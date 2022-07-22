/**
 * @author suzailong
 * @date 2022/6/14-6:03 PM
 */
public class DailyTest {
    public static void main(String[] args) {
        String str = " 200";
        // replace space of str
        // str = str.replaceAll("\\s+", "");
        System.out.println(str);
        System.out.println("Long.parseLong(str) = " + Long.parseLong(str));
        System.out.println("Integer.parseInt(str) = " + Integer.parseInt(str));
    }
}
