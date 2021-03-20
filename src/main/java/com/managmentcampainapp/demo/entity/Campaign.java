package com.managmentcampainapp.demo.entity;

import javax.persistence.*;

@Entity
public class Campaign {


    @Id
    @SequenceGenerator(name = "product_id_generator", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    private Long id;

    private String name;

    private String keyword;

    private Long bigAmount;

    private Long campaignFound;

    private String status;

    private String town;

    private Long radius;


    public Campaign() {
    }

    public Campaign(Long id, String name,
                    String keyword,
                    Long bigAmount,
                    Long campaignFound,
                    String status,
                    String town,
                    Long radius) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.bigAmount = bigAmount;
        this.campaignFound = campaignFound;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public Campaign(String name,
                    String keyword,
                    Long bigAmount,
                    Long campaignFound,
                    String status,
                    String town,
                    Long radius) {
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
