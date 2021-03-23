import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Campaign} from '../../models';
import {CampaignServiceService} from '../../CampaingService/campaign-service.service';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';


class T {
}

@Component({
  selector: 'app-campaigns',
  templateUrl: './campaigns.component.html',
  styleUrls: ['./campaigns.component.css']
})
export class CampaignsComponent implements OnInit, AfterViewInit {

  campaignsList: Campaign[] = [];
  displayedColumns: string[] = ['id', 'name', 'keyword', 'bidAmount', 'campaignFound', 'status', 'town', 'radius', 'action'];
  dataSource = new MatTableDataSource(this.campaignsList);
  budget: number;

  campaignToEdit: Campaign;


  addForm: FormGroup;
  name = new FormControl('', [Validators.required]);
  keyword = new FormControl('', [Validators.required]);
  bidAmount = new FormControl('', [Validators.required]);
  campaignFound = new FormControl('', [Validators.required]);
  radius = new FormControl('', [Validators.required]);
  town = new FormControl('', [Validators.required]);
  status = new FormControl('', [Validators.required]);

  @ViewChild(MatSort) sort: MatSort;

  constructor(private campaignService: CampaignServiceService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {

    this.addForm = this.formBuilder.group({
      name: this.name,
      keyword: this.keyword,
      bidAmount: this.bidAmount,
      campaignFound: this.campaignFound,
      status: this.status,
      town: this.town,
      radius: this.radius
    }, {
      validator: [this.checkInRange('bidAmount'), this.checkIfNameAvailable('name'),
        this.checkNegRadius('radius'), this.checkNegCampFound('campaignFound')]
    });
    this.campaignService.getCampaigns$().subscribe(
      value => {
        this.campaignsList = value;
        this.dataSource = new MatTableDataSource(this.campaignsList);
        this.dataSource.sort = this.sort;
      }
    );
    this.campaignService.getBudget().subscribe(
      value => this.budget = value
    );

  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
  }

  deleteCampaign(campaignId: number): void {
    this.campaignService.deleteCampaign(campaignId);
  }

  getErrorMessageName(): string {
    if (this.name.hasError('required')) {
      return 'You must enter an name';
    }
  }

  getErrorMessageKeyword(): string {
    if (this.keyword.hasError('required')) {
      return 'You must enter a keywords';
    }
  }

  getErrorMessageBidAmount(): string {
    if (this.bidAmount.hasError('required')) {
      return 'You must enter a BidAmount';
    }
  }

  getErrorMessageCampaignFound(): string {
    if (this.campaignFound.hasError('required')) {
      return 'You must enter a Camp.Found';
    }
  }

  getErrorMessageRadius(): string {
    if (this.radius.hasError('required')) {
      return 'You must enter a Radius';
    }
  }

  get form(): any {
    return this.addForm.controls;
  }

  add(): any {
    this.campaignService.addCampaign(
      {
        name: this.form.name.value,
        keyword: this.form.keyword.value,
        bidAmount: this.form.bidAmount.value,
        campaignFound: this.form.campaignFound.value,
        status: this.form.status.value,
        town: this.form.town.value,
        radius: this.form.radius.value,
      }
    )
  }

  checkInRange(amount: string): any {
    return (group: FormGroup) => {
      const amountInput = group.controls[amount];

      if (amountInput.value === '') {
        return amountInput.setErrors({nullValueBidAmount: true});
      }
      if (amountInput.value < 0) {
        return amountInput.setErrors({lower: true});
      }
      if (amountInput.value > this.budget) {
        return amountInput.setErrors({higher: true});
      } else {
        return amountInput.setErrors(null);
      }
    };
  }

  checkNegCampFound(camFound: string): any {
    return (group: FormGroup) => {
      const camFoundInput = group.controls[camFound];

      if (camFoundInput.value < 0) {
        return camFoundInput.setErrors({negativeCamFounds: true});
      }
    };
  }

  checkNegRadius(radius: string): any {
    return (group: FormGroup) => {
      const radiusInput = group.controls[radius];

      if (radiusInput.value < 0) {
        return radiusInput.setErrors({negativeRadius: true});
      }
    };
  }

  checkIfNameAvailable(name: string): any {
    return (group: FormGroup) => {
      const nameInput = group.controls[name];
      if (nameInput.value === '') {
        return nameInput.setErrors({nullValueName: true});
      }

      for (const entry of this.campaignsList) {

        if (entry.name === nameInput.value) {
          return nameInput.setErrors({duplicate: true});
        }
      }
      return nameInput.setErrors(null);
    };
  }


  openEditModule(id: number): void {
    this.campaignService.getCampaignById(id).subscribe(
      value => this.campaignToEdit = value);
  }

  update($event: Campaign): void {
    this.campaignService.updateCampaign($event).subscribe();
  }
}
