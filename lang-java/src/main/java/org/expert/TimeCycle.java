package org.expert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TimeCycle {
    /**
     * 周期编号 从 1 开始
     */
    private int periodNumber;  // 周期编号
    private Date periodStartDate;  // 周期开始时间
    private Date periodEndDate;  // 周期结束时间

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Period " + periodNumber + ": " + sdf.format(periodStartDate) + " - " + sdf.format(periodEndDate);
    }
}
