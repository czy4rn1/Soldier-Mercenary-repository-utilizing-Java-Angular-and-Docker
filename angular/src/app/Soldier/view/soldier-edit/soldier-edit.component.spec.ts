import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldierEditComponent } from './soldier-edit.component';

describe('SoldierEditComponent', () => {
  let component: SoldierEditComponent;
  let fixture: ComponentFixture<SoldierEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SoldierEditComponent]
    });
    fixture = TestBed.createComponent(SoldierEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
