package com.managmentcampainapp.demo.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignDto {

    private Long id;

    private String name;

    private String keyword;

    private Long bigAmount;

    private Long campaignFound;

    private String status;

    private String town;

    private Long radius;

    @JsonCreator
    public CampaignDto(@JsonProperty("id") Long id,
                       @JsonProperty("name") String name,
                       @JsonProperty("keyword") String keyword,
                       @JsonProperty("bigAmount") Long bigAmount,
                       @JsonProperty("campaignFound") Long campaignFound,
                       @JsonProperty("status") String status,
                       @JsonProperty("town") String town,
                       @JsonProperty("radius") Long radius) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.bigAmount = bigAmount;
        this.campaignFound = campaignFound;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getBigAmount() {
        return bigAmount;
    }

    public void setBigAmount(Long bigAmount) {
        this.bigAmount = bigAmount;
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
