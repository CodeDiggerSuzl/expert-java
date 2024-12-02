import lombok.extern.slf4j.Slf4j;
import org.hashids.Hashids;
import org.junit.Test;

import java.util.Arrays;


@Slf4j
public class HashIdDemo {


    /*--------------------------------------------------------------------------------------------------------------*/


    /*--------------------------------------------------------------------------------------------------------------*/
    @Test
    public void test() {

    }


    //    public static void main(String[] args) {
    //        String salt = "this is";
    //        Hashids hashids = new Hashids(salt);
    //
    //        for (int i = 0; i < 10; i++) {
    //
    //            String longString = "50000001";
    //            String encoded = hashids.encodeHex(longString);
    //            System.out.println("Encoded: " + encoded);
    //            String decoded = hashids.decodeHex(encoded);
    //            System.out.println("Decoded: " + decoded);
    //        }
    //    }


    private static final String salt_prefix = "fX0*yS0.gW0+tD0]uE6+";


    public static String encodeCouponId(Long activityId, Long number) {
        String totalSalt = salt_prefix;
        Hashids hashids = new Hashids(totalSalt, 10);
        return hashids.encode(activityId, number);
    }

    public static String decodeCouponId(String encodedStr) {
        String totalSalt = salt_prefix;
        Hashids hashids = new Hashids(totalSalt, 9);
        long[] decode = hashids.decode(encodedStr);
        return Arrays.toString(decode);
    }

    public static void main(String[] args) {
        // int prevUpLoadCnt = 1;
        // List<String> couponIdList = new ArrayList<>(2);
        //
        // for (int i = 12; i <= 11; i++) {
        //     String couponId = encodeCouponId(1L, (long) i);
        //     couponIdList.add(couponId);
        //     if (couponIdList.size() == 2 || i == 10) {
        //         log.info("coupon id = {}", couponIdList);
        //         couponIdList.clear();
        //     }
        //
        // }

        //        String s = String.format("unique_%s", 200);
        //        System.out.println("s = " + s);

    }

}
