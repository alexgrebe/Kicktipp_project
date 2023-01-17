import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MinispielComponent } from './minispiel.component';

describe('MinispielComponent', () => {
  let component: MinispielComponent;
  let fixture: ComponentFixture<MinispielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MinispielComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MinispielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
