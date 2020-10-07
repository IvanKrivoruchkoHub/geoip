import { TestBed } from '@angular/core/testing';

import { IpDetailService } from './ip-detail.service';

describe('IpDetailService', () => {
  let service: IpDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IpDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
