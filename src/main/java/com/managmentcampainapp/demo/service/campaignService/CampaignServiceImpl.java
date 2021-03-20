package com.managmentcampainapp.demo.service.campaignService;

import com.managmentcampainapp.demo.dto.CampaignDto;
import com.managmentcampainapp.demo.dto.NewCampaignDto;
import com.managmentcampainapp.demo.entity.Campaign;
import com.managmentcampainapp.demo.exception.IdNotFoundException;
import com.managmentcampainapp.demo.repository.CampaignRepository;
import com.managmentcampainapp.demo.util.CampaignDtoConverter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign findCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id, Campaign.class.getSimpleName()));
    }

    @Override
    public List<Campaign> findAllCampaigns(Long id) {
        return (List<Campaign>) campaignRepository.findAll();
    }

    @Override
    public void updateCampaign(CampaignDto campaignDto) {
        campaignRepository.save(
                CampaignDtoConverter.CampaignDtoConvertToCampaign(campaignDto)
        );
    }

    @Override
    public void deleteCampaign(Long id) {
        try {
            campaignRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IdNotFoundException(id, Campaign.class.getSimpleName());
        }
    }

    @Override
    public void addCampaign(NewCampaignDto newCampaignDto) {
        campaignRepository.save(
                CampaignDtoConverter.NewCampaignDtoConvertToCampaign(newCampaignDto)
        );
    }
}
