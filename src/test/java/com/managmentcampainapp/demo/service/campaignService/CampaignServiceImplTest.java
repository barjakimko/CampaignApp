package com.managmentcampainapp.demo.service.campaignService;

import com.managmentcampainapp.demo.dto.CampaignDto;
import com.managmentcampainapp.demo.entity.Campaign;
import com.managmentcampainapp.demo.exception.IdNotFoundException;
import com.managmentcampainapp.demo.repository.CampaignRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class CampaignServiceImplTest {

    @Mock
    private CampaignRepository campaignRepository;

    @InjectMocks
    private CampaignServiceImpl campaignService;


    @Before
    public void init() {
        campaignRepository.save(new Campaign(
                1L,
                "First cam",
                "first",
                10L,
                10L,
                "Off",
                "Kraków",
                10L));
    }

    @Test
    public void should_throw_exception_when_campaign_to_be_deleted_not_found() {
        //budget should stay unchanged
        int budgetBeforeDel = Campaign.getBudget();

        // given:
        Long id = 1L;

        // when:
        Throwable exception = catchThrowable(() -> campaignService.deleteCampaign(id));

        // then:
        assertThat(exception).isInstanceOf(IdNotFoundException.class)
                .hasMessage("Id= " + id + " not found for " + Campaign.class.getSimpleName());

        int budgetAfterDel = Campaign.getBudget();

        assertEquals(budgetBeforeDel, budgetAfterDel);
    }

    @Test
    public void should_throw_exception_when_campaign_to_be_update_not_found() {
        //budget should stay unchanged
        int budgetBeforeDel = Campaign.getBudget();

        // given:
        CampaignDto campaignDto = new CampaignDto(
                1L,
                "First cam",
                "first",
                10L,
                10L,
                "Off",
                "Kraków",
                10L);

        // when:
        Throwable exception = catchThrowable(() -> campaignService.updateCampaign(campaignDto));

        // then:
        assertThat(exception).isInstanceOf(IdNotFoundException.class)
                .hasMessage("Id= " + campaignDto.getId() + " not found for " + Campaign.class.getSimpleName());

        int budgetAfterDel = Campaign.getBudget();

        assertEquals(budgetBeforeDel, budgetAfterDel);
    }

    @Test
    public void should_throw_exception_when_campaignId_to_update_null() {
        //budget should stay unchanged
        int budgetBeforeDel = Campaign.getBudget();

        // given:
        CampaignDto campaignDto = new CampaignDto(
                null,
                "First cam",
                "first",
                10L,
                10L,
                "Off",
                "Kraków",
                10L);

        // when:
        Throwable exception = catchThrowable(() -> campaignService.updateCampaign(campaignDto));
        // then:
        assertThat(exception).isInstanceOf(IdNotFoundException.class)
                .hasMessage("Id can't be null");

        int budgetAfterDel = Campaign.getBudget();

        assertEquals(budgetBeforeDel, budgetAfterDel);
    }

    @Test
    public void should_throw_exception_when_campaignId_to_update_not_found() {
        //budget should stay unchanged
        int budgetBeforeDel = Campaign.getBudget();

        // given:
        CampaignDto campaignDto = new CampaignDto(
                1L,
                "First cam",
                "first",
                10L,
                10L,
                "Off",
                "Kraków",
                10L);

        // when:
        Throwable exception = catchThrowable(() -> campaignService.updateCampaign(campaignDto));
        // then:
        assertThat(exception).isInstanceOf(IdNotFoundException.class)
                .hasMessage("Id= " + campaignDto.getId() + " not found for " + Campaign.class.getSimpleName());

        int budgetAfterDel = Campaign.getBudget();

        assertEquals(budgetBeforeDel, budgetAfterDel);
    }
}

