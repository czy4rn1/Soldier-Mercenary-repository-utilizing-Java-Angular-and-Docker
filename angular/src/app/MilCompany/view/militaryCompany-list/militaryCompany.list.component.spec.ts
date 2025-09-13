import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MilitaryCompanyListComponent } from './militaryCompany.list.component';

describe('MilitaryCompanyListComponent', () => {
  let component: MilitaryCompanyListComponent;
  let fixture: ComponentFixture<MilitaryCompanyListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MilitaryCompanyListComponent]
    });
    fixture = TestBed.createComponent(MilitaryCompanyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
