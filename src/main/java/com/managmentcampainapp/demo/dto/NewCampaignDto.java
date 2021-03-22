package com.managmentcampainapp.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCampaignDto {

    private String name;

    private String keyword;

    private Long bidAmount;

    private Long campaignFound;

    private String status;

    private String town;

    private Long radius;

    @JsonCreator
    public NewCampaignDto(@JsonProperty("name") String name,
                          @JsonProperty("keyword") String keyword,
                          @JsonProperty("bidAmount") Long bidAmount,
                          @JsonProperty("campaignFound") Long campaignFound,
                          @JsonProperty("status") String status,
                          @JsonProperty("town") String town,
                          @JsonProperty("radius") Long radius) {
        this.name = name;
        this.keyword = keyword;
        this.bidAmount = bidAmount;
        this.campaignFound = campaignFound;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Long getCampaignFound() {
        return campaignFound;
    }

    public void setCampaignFound(Long campaignFound) {
        this.campaignFound = campaignFound;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }
}
