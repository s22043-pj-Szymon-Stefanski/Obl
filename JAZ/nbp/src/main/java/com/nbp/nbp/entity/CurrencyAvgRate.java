package com.nbp.nbp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel(value = "CurrencyAvgRate", description = "Query log regarding average rates")
@Entity
public class CurrencyAvgRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Unique identifier of particular query", readOnly = true)
    private Long queryId;
    @ApiModelProperty(value = "Standard code of the selected currency")
    private String currencyCode;
    @ApiModelProperty(value = "Name of the selected currency in Polish")
    private String currencyName;
    @ApiModelProperty(value = "Average price calculated for selected currency within given number of days back")
    private double avgRate;
    @ApiModelProperty(value = "Selected number of days back")
    private int daysBack;
    @ApiModelProperty(value = "Exact time of the query")
    private Timestamp queryTs;

    public CurrencyAvgRate() {

    }

    public CurrencyAvgRate(Long queryId, String currencyCode, String currencyName, double avgRate, int daysBack, Timestamp queryTs) {
        this.queryId = queryId;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.avgRate = avgRate;
        this.daysBack = daysBack;
        this.queryTs = queryTs;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    public int getDaysBack() {
        return daysBack;
    }

    public void setDaysBack(int daysBack) {
        this.daysBack = daysBack;
    }

    public Timestamp getQueryTs() {
        return queryTs;
    }

    public void setQueryTs(Timestamp queryTs) {
        this.queryTs = queryTs;
    }

    @Override
    public String toString() {
        return "CurrencyAvgRate{" +
                "queryId=" + queryId +
                ", currencyCode=" + currencyCode +
                ", currencyName='" + currencyName + '\'' +
                ", avgRate=" + avgRate +
                ", daysBack=" + daysBack +
                ", queryTs=" + queryTs +
                '}';
    }
}
