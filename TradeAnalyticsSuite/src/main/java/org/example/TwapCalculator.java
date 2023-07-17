/**
 * TradeAnalyticsSuite
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/7/17
 **/
package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TwapCalculator {
    public static void main(String[] args) {
        // 模拟一个价格序列，包含时间和价格
        PriceData[] priceData = new PriceData[] {
                new PriceData(LocalDateTime.of(2023, 7, 17, 9, 0), new BigDecimal("10.00")),
                new PriceData(LocalDateTime.of(2023, 7, 17, 9, 1), new BigDecimal("10.05")),
                new PriceData(LocalDateTime.of(2023, 7, 17, 9, 2), new BigDecimal("10.02")),
                new PriceData(LocalDateTime.of(2023, 7, 17, 9, 3), new BigDecimal("10.08")),
                new PriceData(LocalDateTime.of(2023, 7, 17, 9, 4), new BigDecimal("10.15")),
                new PriceData(LocalDateTime.of(2023, 7, 17, 9, 5), new BigDecimal("10.12"))
        };

        // 计算TWAP
        BigDecimal totalValue = BigDecimal.ZERO;  // 总交易量
        BigDecimal totalPrice = BigDecimal.ZERO;  // 总价格

        for (PriceData data : priceData) {
            totalValue = totalValue.add(data.price);
            totalPrice = totalPrice.add(data.price);
        }

        BigDecimal twap = totalPrice.divide(totalValue, 2, BigDecimal.ROUND_HALF_UP);

        System.out.println("TWAP: " + twap);
    }
}

// 价格数据类
class PriceData {
    LocalDateTime time;
    BigDecimal price;

    public PriceData(LocalDateTime time, BigDecimal price) {
        this.time = time;
        this.price = price;
    }
}

