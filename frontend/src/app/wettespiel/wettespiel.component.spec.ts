import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WettespielComponent } from './wettespiel.component';

describe('WettespielComponent', () => {
  let component: WettespielComponent;
  let fixture: ComponentFixture<WettespielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WettespielComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WettespielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
