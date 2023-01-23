import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WettenadminComponent } from './wettenadmin.component';

describe('WettenadminComponent', () => {
  let component: WettenadminComponent;
  let fixture: ComponentFixture<WettenadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WettenadminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WettenadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
