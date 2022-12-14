import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipprundeComponent } from './tipprunde.component';

describe('TipprundeComponent', () => {
  let component: TipprundeComponent;
  let fixture: ComponentFixture<TipprundeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipprundeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipprundeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
