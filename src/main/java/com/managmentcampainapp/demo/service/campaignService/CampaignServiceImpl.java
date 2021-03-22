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
    public CampaignDto findCampaignById(Long id) {
        return CampaignDtoConverter.CampaignConvertToCampaignDto(
                campaignRepository.findById(id)
                        .orElseThrow(() -> new IdNotFoundException(id, Campaign.class.getSimpleName()))
        );
    }

    @Override
    public List<CampaignDto> findAllCampaigns() {
        return CampaignDtoConverter.
                CampaignListConvertToCampaignDtoList((List<Campaign>) campaignRepository.findAll());
    }

    @Override
    public void updateCampaign(CampaignDto campaignDto) {
        Long id = campaignDto.getId();
        if (id == null) {
            throw new IdNotFoundException("Id can't be null");
        }
        Long charging = campaignDto.getBidAmount();
        Long refund = campaignRepository.findById(id)

                .orElseThrow(() -> new IdNotFoundException(id, Campaign.class.getSimpleName()))
                .getBidAmount();
        campaignRepository.save(
                CampaignDtoConverter.CampaignDtoConvertToCampaign(campaignDto));

        Campaign.decreaseBudget(charging);
        Campaign.increaseBudget(refund);
    }

    @Override
    public void deleteCampaign(Long id) {
        Long refund = findCampaignById(id).getBidAmount();
        try {
            campaignRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IdNotFoundException(id, Campaign.class.getSimpleName());
        }

        Campaign.increaseBudget(refund);

    }

    @Override
    public void addCampaign(NewCampaignDto newCampaignDto) {
        Long charging = newCampaignDto.getBidAmount();
        campaignRepository.save(
                CampaignDtoConverter.NewCampaignDtoConvertToCampaign(newCampaignDto)
        );

        Campaign.decreaseBudget(charging);
    }
}
