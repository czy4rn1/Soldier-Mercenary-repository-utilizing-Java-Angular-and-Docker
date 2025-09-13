import { TestBed } from '@angular/core/testing';

import { MilitaryCompanyService } from './militaryCompany.service';

describe('MilitaryCompanyService', () => {
  let service: MilitaryCompanyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MilitaryCompanyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
