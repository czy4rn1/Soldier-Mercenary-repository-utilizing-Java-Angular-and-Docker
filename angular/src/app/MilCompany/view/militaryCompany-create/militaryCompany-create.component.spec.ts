import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MilitaryCompanyAdditionComponent } from './militaryCompany-create.component';

describe('MilitaryCompanyAdditionComponent', () => {
  let component: MilitaryCompanyAdditionComponent;
  let fixture: ComponentFixture<MilitaryCompanyAdditionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MilitaryCompanyAdditionComponent]
    });
    fixture = TestBed.createComponent(MilitaryCompanyAdditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
