import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Campaign, CampaignDto} from '../models';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CampaignServiceService {


  constructor(private http: HttpClient) {
  }

  getCampaigns$(): Observable<Campaign[]> {
    const url = 'http://localhost:8080/api/v1/campaigns';
    return this.http.get<Campaign[]>(url);
  }

  deleteCampaign(campaignId: number): void {
    setTimeout(this.refresh, 500);
    this.http.delete('http://localhost:8080/api/v1/campaigns/' + campaignId)
      .subscribe(() => console.log('campaign deleted'));
  }

  addCampaign(campaign: { keyword: any; town: any; campaignFound: any;
  name: any; bidAmount: any; radius: any; status: any }):
    Observable<CampaignDto> {
    setTimeout(this.refresh, 500);
    return this.http.post<any>('http://localhost:8080/api/v1/campaigns/', campaign);
  }

  updateCampaign(campaign: { id: any; keyword: any; town: any; campaignFound: any; name: any; bidAmount: any; radius: any; status: any }):
    Observable<Campaign> {
    setTimeout(this.refresh, 500);
    return this.http.put<any>('http://localhost:8080/api/v1/campaigns/', campaign);
  }

  getCampaignById(campaignId: number): Observable<Campaign> {
    return this.http.get<Campaign>('http://localhost:8080/api/v1/campaigns/' + campaignId);
  }

  getBudget(): Observable<number> {
    return this.http.get<number>('http://localhost:8080/api/v1/campaigns/budget');
  }

  refresh(): void {
    window.location.reload();
  }
}
