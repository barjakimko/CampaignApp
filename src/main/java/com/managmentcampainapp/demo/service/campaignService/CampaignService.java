package com.managmentcampainapp.demo.service.campaignService;

import com.managmentcampainapp.demo.dto.CampaignDto;
import com.managmentcampainapp.demo.dto.NewCampaignDto;

import java.util.List;

public interface CampaignService {

    CampaignDto findCampaignById(Long id);

    List<CampaignDto> findAllCampaigns();

    void updateCampaign(CampaignDto campaignDto);

    void addCampaign(NewCampaignDto newCampaignDto);

    void deleteCampaign(Long id);
}
