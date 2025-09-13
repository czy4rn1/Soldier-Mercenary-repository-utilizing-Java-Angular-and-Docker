import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldierViewComponent } from './soldier-view.component';

describe('SoldierViewComponent', () => {
  let component: SoldierViewComponent;
  let fixture: ComponentFixture<SoldierViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SoldierViewComponent]
    });
    fixture = TestBed.createComponent(SoldierViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
