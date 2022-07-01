package com.nbp.nbp.service;

import com.nbp.nbp.entity.CurrencyAvgRate;
import com.nbp.nbp.entity.Rate;
import com.nbp.nbp.entity.RateQueryResult;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class RatesService {

    private static final String RATES_URL = "https://api.nbp.pl/api/exchangerates/rates/a";

    private final RestTemplate restTemplate;

    public RatesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RateQueryResult getTodayRateByCode(String code){
        return this.restTemplate.exchange(RATES_URL + "/" + code + "/today/", HttpMethod.GET, null,
                RateQueryResult.class).getBody();
    }

    public RateQueryResult getTodayRateUsd(){
        return this.restTemplate.exchange(RATES_URL + "/USD/today/", HttpMethod.GET, null,
                RateQueryResult.class).getBody();
    }

    public RateQueryResult getRateUsdByDate(String effectiveDate) {
        return this.restTemplate.exchange(RATES_URL + "/USD/" + effectiveDate + "/", HttpMethod.GET, null,
                RateQueryResult.class).getBody();
    }

    public RateQueryResult getRateByDateAndCode(String code, String effectiveDate) {
        return this.restTemplate.exchange(RATES_URL + "/" + code +  "/" + effectiveDate + "/", HttpMethod.GET, null,
                RateQueryResult.class).getBody();
    }

    public RateQueryResult getRatesByCodeAndNoOfDays(String currencyCode, int daysBack){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endDate = dateFormat.format(currentDate);
        String startDate = dateFormat.format(currentDate.minusDays(daysBack));
        return this.restTemplate.exchange(RATES_URL + "/" + currencyCode + "/" + startDate + "/" + endDate,
                HttpMethod.GET, null, RateQueryResult.class).getBody();
    }

    public List<Rate> returnMidRates(String currencyCode, int daysBack){
        List<Rate> allRates = getRatesByCodeAndNoOfDays(currencyCode, daysBack).getRates();

        return allRates;
    }



}
