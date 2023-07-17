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

public class VwapCalculator {

    public static void main(String[] args) {
        // 模拟一个价格和成交量序列，包含时间、价格和成交量
        TradeData[] tradeData = new TradeData[]{
                new TradeData(LocalDateTime.of(2023, 7, 17, 9, 0), new BigDecimal("10.00"), 100),
                new TradeData(LocalDateTime.of(2023, 7, 17, 9, 1), new BigDecimal("10.05"), 150),
                new TradeData(LocalDateTime.of(2023, 7, 17, 9, 2), new BigDecimal("10.02"), 200),
                new TradeData(LocalDateTime.of(2023, 7, 17, 9, 3), new BigDecimal("10.08"), 180),
                new TradeData(LocalDateTime.of(2023, 7, 17, 9, 4), new BigDecimal("10.15"), 220),
                new TradeData(LocalDateTime.of(2023, 7, 17, 9, 5), new BigDecimal("10.12"), 120)
        };

        // 计算VWAP
        int totalVolume = 0;       // 总成交量
        BigDecimal totalPriceVol = BigDecimal.ZERO;  // 成交量乘以价格的总和

        for (TradeData data : tradeData) {
            totalVolume += data.volume;
            BigDecimal priceVol = data.price.multiply(BigDecimal.valueOf(data.volume));
            totalPriceVol = totalPriceVol.add(priceVol);
        }

        BigDecimal vwap = totalPriceVol.divide(BigDecimal.valueOf(totalVolume), 2, BigDecimal.ROUND_HALF_UP);

        System.out.println("VWAP: " + vwap);
    }
}

// 交易数据类
class TradeData {
    LocalDateTime time;
    BigDecimal price;
    int volume;

    public TradeData(LocalDateTime time, BigDecimal price, int volume) {
        this.time = time;
        this.price = price;
        this.volume = volume;
    }
}
