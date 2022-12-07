import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreundeslisteComponent } from './freundesliste.component';

describe('FreundeslisteComponent', () => {
  let component: FreundeslisteComponent;
  let fixture: ComponentFixture<FreundeslisteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FreundeslisteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FreundeslisteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
