import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipprundeneinladungComponent } from './tipprundeneinladung.component';

describe('TipprundeneinladungComponent', () => {
  let component: TipprundeneinladungComponent;
  let fixture: ComponentFixture<TipprundeneinladungComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipprundeneinladungComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipprundeneinladungComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
