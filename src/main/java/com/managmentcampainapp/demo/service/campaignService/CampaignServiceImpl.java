package com.managmentcampainapp.demo.service.campaignService;

import com.managmentcampainapp.demo.entity.Campaign;
import com.managmentcampainapp.demo.exception.IdNotFoundException;
import com.managmentcampainapp.demo.repository.CampaignRepository;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign findCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(()-> new IdNotFoundException(id, Campaign.class.getSimpleName()));
    }
}
