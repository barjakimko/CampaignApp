package com.managmentcampainapp.demo.util;

import com.managmentcampainapp.demo.dto.CampaignDto;
import com.managmentcampainapp.demo.dto.NewCampaignDto;
import com.managmentcampainapp.demo.entity.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampaignDtoConverter {

    public static Campaign CampaignDtoConvertToCampaign(CampaignDto campaignDto) {
        return new Campaign(
                campaignDto.getId(),
                campaignDto.getName(),
                campaignDto.getKeyword(),
                campaignDto.getBigAmount(),
                campaignDto.getCampaignFound(),
                campaignDto.getStatus(),
                campaignDto.getTown(),
                campaignDto.getRadius()
        );
    }

    public static Campaign NewCampaignDtoConvertToCampaign(NewCampaignDto newCampaignDto) {
        return new Campaign(
                newCampaignDto.getName(),
                newCampaignDto.getKeyword(),
                newCampaignDto.getBigAmount(),
                newCampaignDto.getCampaignFound(),
                newCampaignDto.getStatus(),
                newCampaignDto.getTown(),
                newCampaignDto.getRadius()
        );
    }

    public static CampaignDto CampaignConvertToCampaignDto(Campaign campaign) {
        return new CampaignDto(
                campaign.getId(),
                campaign.getName(),
                campaign.getKeyword(),
                campaign.getBidAmount(),
                campaign.getCampaignFound(),
                campaign.getStatus(),
                campaign.getTown(),
                campaign.getRadius()
        );
    }

    public static List<CampaignDto> CampaignListConvertToCampaignDtoList(List<Campaign> campaignList) {
        return campaignList.stream()
                .map(campaign -> CampaignConvertToCampaignDto(campaign))
                .collect(Collectors.toList());
    }
}
