import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MilitaryCompanyEditComponent } from './militaryCompany-edit.component';

describe('MilitaryCompanyEditComponent', () => {
  let component: MilitaryCompanyEditComponent;
  let fixture: ComponentFixture<MilitaryCompanyEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MilitaryCompanyEditComponent]
    });
    fixture = TestBed.createComponent(MilitaryCompanyEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
