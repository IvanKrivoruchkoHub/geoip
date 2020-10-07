import { Component } from '@angular/core';
import {IpDetailService} from './ip-detail.service';
import {IpDetail} from './ipDetail';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'geoip-ng';

  ipDetail: IpDetail;

  ipv4: string;

  constructor(private ipDetailService: IpDetailService) { }

  getIpDetail() {
    this.ipDetail =  this.ipDetailService.getDataFromServer(this.ipv4);
  }
}
