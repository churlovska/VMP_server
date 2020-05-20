package com.vmp.server.response;

import java.util.ArrayList;

public class EstimateCountResponse {

    private Double placement_fin;
    private Double b1_price;
    private Double price_fin;
    private Double price_vat_fin;
    private ArrayList<EstimateResponse> estimateResponses;

    public EstimateCountResponse() {
    }

    public EstimateCountResponse(Double placement_fin, Double b1_price, Double price_fin, Double price_vat_fin, ArrayList<EstimateResponse> estimateResponses) {
        this.placement_fin = placement_fin;
        this.b1_price = b1_price;
        this.price_fin = price_fin;
        this.price_vat_fin = price_vat_fin;
        this.estimateResponses = estimateResponses;
    }

    public Double getPlacement_fin() {
        return placement_fin;
    }

    public void setPlacement_fin(Double placement_fin) {
        this.placement_fin = placement_fin;
    }

    public Double getB1_price() {
        return b1_price;
    }

    public void setB1_price(Double b1_price) {
        this.b1_price = b1_price;
    }

    public Double getPrice_fin() {
        return price_fin;
    }

    public void setPrice_fin(Double price_fin) {
        this.price_fin = price_fin;
    }

    public Double getPrice_vat_fin() {
        return price_vat_fin;
    }

    public void setPrice_vat_fin(Double price_vat_fin) {
        this.price_vat_fin = price_vat_fin;
    }

    public ArrayList<EstimateResponse> getEstimateResponses() {
        return estimateResponses;
    }

    public void setEstimateResponses(ArrayList<EstimateResponse> estimateResponses) {
        this.estimateResponses = estimateResponses;
    }
}
