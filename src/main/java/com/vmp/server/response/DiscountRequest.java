package com.vmp.server.response;

public class DiscountRequest {

    private Integer aoCount;
    private Integer duration;
    private Double price;
    private Double discount;
    private Double strDiscount;

    public DiscountRequest() {
    }

    public DiscountRequest(Integer aoCount, Integer duration, Double price, Double discount, Double strDiscount) {
        this.aoCount = aoCount;
        this.duration = duration;
        this.price = price;
        this.discount = discount;
        this.strDiscount = strDiscount;
    }

    public Integer getAoCount() {
        return aoCount;
    }

    public void setAoCount(Integer aoCount) {
        this.aoCount = aoCount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getStrDiscount() {
        return strDiscount;
    }

    public void setStrDiscount(Double strDiscount) {
        this.strDiscount = strDiscount;
    }
}
