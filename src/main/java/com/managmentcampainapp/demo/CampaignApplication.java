package com.managmentcampainapp.demo;


import com.managmentcampainapp.demo.dto.NewCampaignDto;
import com.managmentcampainapp.demo.service.campaignService.CampaignService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampaignApplication {

    private final CampaignService campaignService;

    public CampaignApplication(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CampaignApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {

            NewCampaignDto campaign1 = new NewCampaignDto(
                    "First cam",
                    "first",
                    10L,
                    10L,
                    "Off",
                    "Kraków",
                    10L);
            NewCampaignDto campaign2 = new NewCampaignDto(
                    "Second cam",
                    "second",
                    20L,
                    20L,
                    "On",
                    "Kraków",
                    20L);
            NewCampaignDto campaign3 = new NewCampaignDto(
                    "Third cam",
                    "third",
                    30L,
                    30L,
                    "On",
                    "Kraków",
                    30L);

            campaignService.addCampaign(campaign1);
            campaignService.addCampaign(campaign2);
            campaignService.addCampaign(campaign3);
        };
    }
}
