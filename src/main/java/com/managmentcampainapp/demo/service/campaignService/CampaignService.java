package com.managmentcampainapp.demo.service.campaignService;

import com.managmentcampainapp.demo.dto.CampaignDto;
import com.managmentcampainapp.demo.dto.NewCampaignDto;
import com.managmentcampainapp.demo.entity.Campaign;

import java.util.List;

public interface CampaignService {

    Campaign findCampaignById(Long id);

    List<Campaign> findAllCampaigns(Long id);

    void updateCampaign(CampaignDto campaignDto);

    void addCampaign(NewCampaignDto newCampaignDto);

    void deleteCampaign(Long id);
}
