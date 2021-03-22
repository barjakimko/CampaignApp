import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CampaignServiceService} from '../../CampaingService/campaign-service.service';
import {Campaign} from '../../models';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private campaignService: CampaignServiceService, private formBuilder: FormBuilder) {
  }

  @Input()
  campaignToEdit: Campaign;
  @Input()
  campaignsList: Campaign[];

  updateForm: FormGroup;
  // name = new FormControl('', [Validators.required]);
  // keyword = new FormControl('', [Validators.required]);
  // bidAmount = new FormControl('', [Validators.required]);
  // campaignFound = new FormControl('', [Validators.required]);
  // radius = new FormControl('', [Validators.required]);
  // town = new FormControl('', [Validators.required]);
  // status = new FormControl('', [Validators.required]);

  @Output()
  campaignEdited = new EventEmitter<Campaign>();

  ngOnInit(): void {
    this.updateForm = this.formBuilder.group({
      name: [this.campaignToEdit.name, Validators.required],
      keyword: [this.campaignToEdit.keyword, Validators.required],
      bidAmount: [this.campaignToEdit.bidAmount, Validators.required],
      campaignFound: [this.campaignToEdit.campaignFound, Validators.required],
      status: [this.campaignToEdit.status, Validators.required],
      town: [this.campaignToEdit.town, Validators.required],
      radius: [this.campaignToEdit.radius, Validators.required]
    }, {
      validator: [this.checkInRange('bidAmount'), this.checkIfNameAvailable('name')]
    });
  }

  getErrorMessageName(): string {
    if (this.updateForm.get('name').hasError('required')) {
      return 'You must enter an name';
    }
  }

  getErrorMessageKeyword(): string {
    if (this.updateForm.get('keyword').hasError('required')) {
      return 'You must enter a keywords';
    }
  }

  getErrorMessageBidAmount(): string {
    if (this.updateForm.get('bidAmount').hasError('required')) {
      return 'You must enter a BidAmount';
    }
  }

  getErrorMessageCampaignFound(): string {
    if (this.updateForm.get('campaignFound').hasError('required')) {
      return 'You must enter a Camp.Found';
    }
  }

  getErrorMessageRadius(): string {
    if (this.updateForm.get('radius').hasError('required')) {
      return 'You must enter a Radius';
    }
  }

  get form(): any {
    return this.updateForm.controls;
  }

  add(): any {
    this.campaignEdited.emit({
      id: this.campaignToEdit.id,
      ...this.updateForm.value
    });
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
      if (amountInput.value > 10000) {
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

      // console.log(this.campaignsList);
      //
      // for (const entry of this.campaignsList) {
      //   console.log(entry.name);
      // }

      for (const entry of this.campaignsList) {
        // console.log(entry.name);
        // console.log(nameInput.value);
        if (entry.name === nameInput.value && entry.name !== this.campaignToEdit.name) {
          return nameInput.setErrors({duplicate: true});
        }
      }
      return nameInput.setErrors(null);
    };
  }

}
