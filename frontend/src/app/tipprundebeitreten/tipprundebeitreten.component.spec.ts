import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipprundebeitretenComponent } from './tipprundebeitreten.component';

describe('TipprundebeitretenComponent', () => {
  let component: TipprundebeitretenComponent;
  let fixture: ComponentFixture<TipprundebeitretenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipprundebeitretenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipprundebeitretenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
