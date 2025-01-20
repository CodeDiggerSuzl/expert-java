import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class VoucherCodeGenerateDemo {


    private static final int batchSize = 10;


    @Test
    public void uploadDemo() {
        Integer stock = 40;
        Integer uploadCnt = 20;
        int index = 23;
        List<Integer> total = new ArrayList<>();
        while (stock - uploadCnt > 0) {
            Integer idxEnd = index + Math.min(batchSize, stock - uploadCnt);
            List<Integer> generate = generateList(index, idxEnd);
            Pair<Integer, Integer> result = upload(generate, total);
            log.info("result={},list={}", result, generate);
            uploadCnt += result.getLeft();
            index = idxEnd;
        }
        log.info("最后 uploadCnt={}, index={}", uploadCnt, index);
        log.info("all upload={}", total);

    }

    List<Integer> generateList(Integer start, Integer end) {
        log.info("start={},indexEnd={}", start, end);
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        return list;
    }


    public static Pair<Integer, Integer> upload(List<Integer> uploadList, List<Integer> total) {
        Integer failCnt = 0, successCnt = 0;
        for (Integer num : uploadList) {
            if (num % 10 == 0) {
                failCnt++;
            } else {
                successCnt++;
                total.add(num);
            }
        }
        return Pair.of(successCnt, failCnt);
    }


    @Test
    public void nullTest() {
        System.out.println("Objects.equals(null,null) = " + Objects.equals(null, null));
    }

    class PrizeInfo {
        private String createTime;

        public PrizeInfo(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateTime() {
            return createTime;
        }
    }

    @Test
    public void test3() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 只对已领奖时间排序 string 格式的时间,排序不对
        // List<PrizeInfo> issuedPrizeInfoList = issuedFu.ture.get().stream().sorted(Comparator.comparing(PrizeInfo::getCreateTime).reversed()).collect(Collectors.toList());


        List<PrizeInfo> issuedFutureList = new ArrayList<>();
        issuedFutureList.add(new PrizeInfo("2025-01-09 16:05:23"));
        issuedFutureList.add(new PrizeInfo("2025-01-09 15:32:51"));
        issuedFutureList.add(new PrizeInfo("2025-01-09 16:14:51"));

        //        issuedFutureList.sort(Comparator.comparing(PrizeInfo::getCreateTime).reversed());
        issuedFutureList.sort((o1, o2) -> o1.getCreateTime().compareTo(o2.getCreateTime()));
        // 修改排序方法
        // List<PrizeInfo> issuedPrizeInfoList = issuedFutureList.stream()
        //         .sorted(Comparator.comparing((PrizeInfo p) -> {
        //             if (p.getCreateTime() == null) {
        //                 return LocalDateTime.MIN;
        //             } else {
        //                 return LocalDateTime.parse(p.getCreateTime(), formatter);
        //             }
        //         }).reversed())
        //         .collect(Collectors.toList());
        System.out.println("  issuedPrizeInfoList = " + JSON.toJSONString(issuedFutureList));
    }

}