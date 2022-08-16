package com.estockmarket.company.query.utils;

import com.estockmarket.company.query.domain.StockPrice;
import com.estockmarket.company.query.dto.CompanyLookupResponse;
import com.estockmarket.cqrscore.domain.BaseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultUtils {

    public static CompanyLookupResponse getResultStats(List<BaseEntity> result) {
        Map<String, Double> stats = new HashMap<>();
        double min = 0, max = 0, avg = 0, sum = 0, count = 0;
        for (BaseEntity entity : result) {
            StockPrice stp = (StockPrice) entity;
            if (min > stp.getCurrentStockPrice()) min = stp.getCurrentStockPrice();
            if (max < stp.getCurrentStockPrice()) min = stp.getCurrentStockPrice();
            sum += stp.getCurrentStockPrice();
            count++;
        }
        count = count != 0 ? count : 1;
        CompanyLookupResponse response = CompanyLookupResponse.builder().data(result).min(min).max(max).avg(sum / count).message("success").build();

        return response;
    }
}
