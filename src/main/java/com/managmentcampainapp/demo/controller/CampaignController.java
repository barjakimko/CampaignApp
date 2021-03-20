package com.managmentcampainapp.demo.controller;

import com.managmentcampainapp.demo.entity.Campaign;
import com.managmentcampainapp.demo.service.campaignService.CampaignService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/product-owner/{productOwnerId}/product/{productId}/campaign/{campaignId}")
    @ResponseStatus(OK)
    public Campaign getCampaignById(@PathVariable Long productOwnerId,
                                    @PathVariable Long productId,
                                    @PathVariable Long campaignId) {
        return campaignService.findCampaignById(campaignId);
    }
}
