import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IpDetail} from './ipDetail';

@Injectable({
  providedIn: 'root'
})
export class IpDetailService {

  constructor(private http: HttpClient) { }
  ipDetail: IpDetail;

  getDataFromServer(ipv4: string): IpDetail{
    this.http.get('http://localhost:8080/geoip/' + ipv4)
      .subscribe(data => {
        this.ipDetail = new IpDetail();
        this.ipDetail.canonicalIPv4Representation = data["canonicalIPv4Representation"];
        this.ipDetail.countryCode = data["countryCode"];
        this.ipDetail.countryName = data["countryName"];
        this.ipDetail.regionName = data["regionName"];
        this.ipDetail.cityName = data["cityName"];
        this.ipDetail.longitude = data["longitude"];
        this.ipDetail.latitude = data["latitude"];
      });
    return this.ipDetail;
  }
}
