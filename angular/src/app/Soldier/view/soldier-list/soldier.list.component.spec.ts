import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldierListComponent } from './soldier.list.component';

describe('SoldierListComponent', () => {
  let component: SoldierListComponent;
  let fixture: ComponentFixture<SoldierListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SoldierListComponent]
    });
    fixture = TestBed.createComponent(SoldierListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
