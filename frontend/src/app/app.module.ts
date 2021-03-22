import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CampaignsComponent } from './Components/Campaigns/campaigns.component';
import {HttpClientModule} from '@angular/common/http';
import {MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';

import {FormsModule} from '@angular/forms';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import { UpdateComponent } from './Components/Update/update.component';




@NgModule({
  declarations: [
    AppComponent,
    CampaignsComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatSortModule,
    MatTableModule,
    BrowserAnimationsModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule
  ],
  providers: [MatSortModule, MatInputModule, MatIconModule, MatDatepickerModule,
    { provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { appearance: 'fill' } }],
  bootstrap: [AppComponent]
})
export class AppModule {}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
