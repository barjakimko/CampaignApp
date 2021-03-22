export interface Campaign {
  id: number;
  name: string;
  keyword: string;
  bidAmount: number;
  campaignFound: number;
  status: string;
  town: string;
  radius: number;
}

export interface CampaignDto {
  name: string;
  keyword: string;
  bidAmount: number;
  campaignFound: number;
  status: string;
  town: string;
  radius: number;
}

