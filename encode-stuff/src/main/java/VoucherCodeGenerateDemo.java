import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

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
}