package com.managmentcampainapp.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Campaign {

    private static int budget = 10_000;

    @Id
    @SequenceGenerator(name = "product_id_generator", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String keyword;

    @NotNull
    @Min(value = 0)
    private Long bidAmount;

    @NotNull
    @Min(value = 0)
    private Long campaignFound;

    @NotNull
    private String status;

    @NotNull
    private String town;

    @NotNull
    private Long radius;


    public Campaign() {
    }

    public Campaign(Long id, String name,
                    String keyword,
                    Long bidAmount,
                    Long campaignFound,
                    String status,
                    String town,
                    Long radius) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.bidAmount = bidAmount;
        this.campaignFound = campaignFound;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public Campaign(String name,
                    String keyword,
                    Long bidAmount,
                    Long campaignFound,
                    String status,
                    String town,
                    Long radius) {
        this.name = name;
        this.keyword = keyword;
        this.bidAmount = bidAmount;
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

    public static void increaseBudget(Long amount) {
        budget += amount;
    }

    public static void decreaseBudget(Long amount) {
        budget -= amount;
    }

    public static int getBudget() {
        return budget;
    }
}
