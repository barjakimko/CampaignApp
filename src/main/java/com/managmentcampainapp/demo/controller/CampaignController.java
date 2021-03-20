package com.managmentcampainapp.demo.controller;

import com.managmentcampainapp.demo.dto.CampaignDto;
import com.managmentcampainapp.demo.dto.NewCampaignDto;
import com.managmentcampainapp.demo.entity.Campaign;
import com.managmentcampainapp.demo.service.campaignService.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/{campaignId}")
    @ResponseStatus(OK)
    public CampaignDto getCampaignById(@PathVariable Long campaignId) {
        return campaignService.findCampaignById(campaignId);
    }

    @GetMapping("")
    @ResponseStatus(OK)
    public List<CampaignDto> getAllCampaigns() {
        return campaignService.findAllCampaigns();
    }


    @PostMapping("")
    @ResponseStatus(CREATED)
    public void createNewCampaign(@RequestBody NewCampaignDto newCampaignDto) {
        campaignService.addCampaign(newCampaignDto);
    }

    @PutMapping("")
    @ResponseStatus(CREATED)
    public void updateCampaign(@RequestBody CampaignDto campaignDto) {
        campaignService.updateCampaign(campaignDto);
    }

    @DeleteMapping("/{campaignId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCampaign(@PathVariable Long campaignId) {
        campaignService.deleteCampaign(campaignId);
    }

    @GetMapping("/budget")
    @ResponseStatus(OK)
    public int getCampaignBudget() {
        return Campaign.getBudget();
    }
}
