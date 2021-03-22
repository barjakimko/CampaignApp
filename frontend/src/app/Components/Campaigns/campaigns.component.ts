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
  dataSource;
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
      validator: [this.checkInRange('bidAmount'), this.checkIfNameAvailable('name')]
    });
    this.campaignService.getCampaigns$().subscribe(
      value => {
        this.campaignsList = value;
        this.dataSource = new MatTableDataSource(this.campaignsList);
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
    // this.campaignService.refresh();
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
      .subscribe(success => {
        if (success) {
          console.log('Campaign updated');
        } else {
          alert('Campaign updated failed');
        }
      }, (error: any) => {
        console.log(error);
      });
    // this.campaignService.refresh();
  }

  checkInRange(amount: string): any {
    return (group: FormGroup) => {
      const amountInput = group.controls[amount];


      console.log(amountInput.value);
      console.log(amountInput.value.valueOf());

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

  checkIfNameAvailable(name: string): any {
    return (group: FormGroup) => {
      const nameInput = group.controls[name];
      if (nameInput.value === '') {
        return nameInput.setErrors({nullValueName: true});
      }
      console.log(this.campaignsList);

      for (const entry of this.campaignsList) {
        console.log(entry.name);
      }

      for (const entry of this.campaignsList) {
        console.log(entry.name);
        console.log(nameInput.value);
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
