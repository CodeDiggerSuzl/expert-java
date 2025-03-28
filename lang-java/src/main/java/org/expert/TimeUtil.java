package org.expert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static cn.hutool.core.date.DateUtil.formatDate;


@Slf4j
public class TimeUtil {


    // 设置日期到当天00:00:00
    private static Date setToStartOfDay(Date date) {
        return DateUtils.truncate(date, Calendar.DATE);
    }

    // 设置日期到当天23:59:59
    private static Date setToEndOfDay(Date date) {
        Date end = DateUtils.ceiling(date, Calendar.DATE);
        return DateUtils.addMilliseconds(end, -1);
    }

    // 计算周期结束时间（含系统截止时间校验）
    private static Date calculateCycleEnd(Date start, int period, Date sysEnd) {
        Date theoreticalEnd = DateUtils.addDays(start, period - 1);
        Date actualEnd = setToEndOfDay(theoreticalEnd);
        return actualEnd.after(sysEnd) ? sysEnd : actualEnd;
    }

    public List<CycleInfo> generateCycles(Date startDate, int plusDays, int period, Date targetDate) {
        List<CycleInfo> cycles = new ArrayList<>();

        // 参数校验
        if (startDate == null || targetDate == null || period <= 0 || plusDays <= 0) {
            return cycles;
        }

        // 计算系统有效期截止时间
        Date sysEndDate = DateUtils.addDays(startDate, plusDays);

        // 目标时间超出有效范围
        if (targetDate.before(startDate) || targetDate.after(sysEndDate)) {
            return cycles;
        }

        // 生成第一个特殊周期
        Date currentCycleStart = startDate;
        Date currentCycleEnd = calculateCycleEnd(currentCycleStart, period, sysEndDate);
        int cycleNumber = 1;
        cycles.add(new CycleInfo(cycleNumber, currentCycleStart, currentCycleEnd));

        // 后续标准周期生成
        Date nextCycleStart = DateUtils.addSeconds(currentCycleEnd, 1);
        while (nextCycleStart.before(sysEndDate) && nextCycleStart.before(targetDate)) {
            currentCycleStart = setToStartOfDay(nextCycleStart);
            currentCycleEnd = calculateCycleEnd(currentCycleStart, period, sysEndDate);

            // 仅添加包含目标时间或之前的周期
            if (currentCycleStart.after(targetDate)) break;

            cycles.add(new CycleInfo(++cycleNumber, currentCycleStart, currentCycleEnd));
            nextCycleStart = DateUtils.addSeconds(currentCycleEnd, 1);
        }

        return cycles;
    }

    public CycleInfo getCurrCycleByTime(Date startDate, int plusDay, int period, Date currentDate) {
        // 参数校验
        if (startDate == null || currentDate == null || period <= 0 || plusDay <= 0) {
            return null;
        }
        // 计算系统总的截止时间（startDate + plusDay 天后的23:59:59）
        Date sysEndDate = DateUtils.addDays(startDate, plusDay);

        // 当前时间不在有效期内
        if (currentDate.before(startDate) || currentDate.after(sysEndDate)) {
            return null;
        }

        // 计算第一个周期的结束时间（startDate + (period-1) 天后的23:59:59）
        Date firstCycleEnd = setToEndOfDay(DateUtils.addDays(startDate, period - 1));

        // 如果当前时间在第一个周期内
        if (!currentDate.after(firstCycleEnd)) {
            Date actualEnd = firstCycleEnd.after(sysEndDate) ? sysEndDate : firstCycleEnd;
            return new CycleInfo(1, startDate, actualEnd);
        }

        // 后续周期计算
        Date baseStartDate = setToStartOfDay(startDate); // 对齐到当天00:00:00
        long daysBetween = (currentDate.getTime() - baseStartDate.getTime()) / (24 * 60 * 60 * 1000);
        long adjustedDays = daysBetween - period;

        int diff = (int) (adjustedDays / period);
        int cycleNumber = 2 + diff; // 序号+1 再加上第一周期

        // 计算周期起始时间（baseStartDate + period + diff*period 天）
        Date cycleStart = DateUtils.addDays(baseStartDate, period + diff * period);
        cycleStart = setToStartOfDay(cycleStart);

        // 计算周期结束时间
        Date cycleEnd = DateUtils.addDays(cycleStart, period - 1);
        cycleEnd = setToEndOfDay(cycleEnd);

        // 确保不超出系统截止时间
        if (cycleEnd.after(sysEndDate)) {
            cycleEnd = sysEndDate;
        }
        return new CycleInfo(cycleNumber, cycleStart, cycleEnd);
    }

    @Test
    public void testList() throws ParseException {
        Date startDate = DateUtils.parseDate("2025-01-01 12:12:00", "yyyy-MM-dd HH:mm:ss");
        Date currDate = DateUtils.parseDate("2025-01-22 10:30:00", "yyyy-MM-dd HH:mm:ss");

        List<CycleInfo> cycleInfoList = generateCycles(startDate, 90, 7, currDate);
        System.out.println((cycleInfoList));
    }

    @Test
    public void test() throws ParseException {
        Date startDate = DateUtils.parseDate("2025-01-01 12:12:00", "yyyy-MM-dd HH:mm:ss");
        int plusDay = 100;  // 100天
        int period = 7;     // 每个周期 7天
        for (int i = 0; i < 100; i++) {
            Date currentDate = DateUtils.addDays(startDate, i);
            // 调用 getPeriod 方法
            String currDate = formatDate(currentDate);
            CycleInfo cycleInfo = getCurrCycleByTime(startDate, plusDay, period, currentDate);
            if (cycleInfo != null) {
                System.out.println(i + " $ " + currDate + " $ " + cycleInfo);  // 输出周期信息
                Date periodEndDate = cycleInfo.getPeriodEndDate();
                Date periodStartDate = cycleInfo.getPeriodStartDate();
                long diffTs = periodEndDate.getTime() - periodStartDate.getTime();
                long l = diffTs / (24 * 60 * 60 * 1000);
                if (l != 6) {
                    System.out.println("l = " + l);
                }
            } else {
                System.out.println("Current date is out of range.");
            }

        }
    }

    @Data
    @AllArgsConstructor
    class CycleInfo {
        private int periodNumber;  // 周期编号
        private Date periodStartDate;  // 周期开始时间
        private Date periodEndDate;  // 周期结束时间

        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return "Period " + periodNumber + ": " + sdf.format(periodStartDate) + " - " + sdf.format(periodEndDate);

        }
    }
}
