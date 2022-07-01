package com.nbp.nbp.controller;

import com.nbp.nbp.entity.CurrencyAvgRate;
import com.nbp.nbp.entity.Rate;
import com.nbp.nbp.entity.RateQueryResult;
import com.nbp.nbp.service.RatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/nbp")
public class RateController {

    public RatesService ratesService;

    RateController(RatesService ratesService){
        this.ratesService = ratesService;
    }

    @GetMapping("/today/{code}")
    public ResponseEntity<RateQueryResult> getTodayRateByCode(@PathVariable String code){
        return ResponseEntity.ok(this.ratesService.getTodayRateByCode(code));
    }

    @GetMapping("/today/dolar")
    public ResponseEntity<RateQueryResult> getTodayRateUsd(){
        return ResponseEntity.ok(this.ratesService.getTodayRateUsd());
    }

    @GetMapping("/dolar/{effectiveDate}")
    public ResponseEntity<RateQueryResult> getRateUsdByDate(@PathVariable String effectiveDate){
        return ResponseEntity.ok(this.ratesService.getRateUsdByDate(effectiveDate));
    }

    @GetMapping("/{code}/{effectiveDate}")
    public ResponseEntity<RateQueryResult> getRateByDateAndCode(@PathVariable String code,
                                                                @PathVariable String effectiveDate){
        return ResponseEntity.ok(this.ratesService.getRateByDateAndCode(code, effectiveDate));
    }

    @GetMapping("/avg/{currencyCode}/days")
    public ResponseEntity<RateQueryResult> getRatesByCodeAndNoOfDays(@PathVariable String currencyCode,
                                                                       @RequestParam int daysBack){
        return ResponseEntity.ok(this.ratesService.getRatesByCodeAndNoOfDays(currencyCode, daysBack));
    }



}
