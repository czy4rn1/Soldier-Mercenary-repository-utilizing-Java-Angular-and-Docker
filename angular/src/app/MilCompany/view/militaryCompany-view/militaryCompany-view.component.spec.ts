import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MilitaryCompanyViewComponent } from './militaryCompany-view.component';

describe('MilitaryCompanyViewComponent', () => {
  let component: MilitaryCompanyViewComponent;
  let fixture: ComponentFixture<MilitaryCompanyViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MilitaryCompanyViewComponent]
    });
    fixture = TestBed.createComponent(MilitaryCompanyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
