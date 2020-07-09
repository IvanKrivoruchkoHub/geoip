import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { IpDetailComponent } from './ip-detail/ip-detail.component';
import { HttpClientModule} from "@angular/common/http";
import { IpDetailService} from "./ip-detail.service";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
    IpDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [IpDetailService],
  bootstrap: [AppComponent]

})
export class AppModule { }
