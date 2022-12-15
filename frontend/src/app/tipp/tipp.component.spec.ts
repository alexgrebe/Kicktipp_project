import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TippComponent } from './tipp.component';

describe('TippComponent', () => {
  let component: TippComponent;
  let fixture: ComponentFixture<TippComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TippComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TippComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
