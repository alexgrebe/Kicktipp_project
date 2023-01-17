import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WettenComponent } from './wetten.component';

describe('WettenComponent', () => {
  let component: WettenComponent;
  let fixture: ComponentFixture<WettenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WettenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WettenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
