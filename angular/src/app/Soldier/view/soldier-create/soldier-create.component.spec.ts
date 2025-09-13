import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldierAdditionComponent } from './soldier-create.component';

describe('SoldierAdditionComponent', () => {
  let component: SoldierAdditionComponent;
  let fixture: ComponentFixture<SoldierAdditionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SoldierAdditionComponent]
    });
    fixture = TestBed.createComponent(SoldierAdditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
