import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipprundeAnzeigenComponent } from './tipprunde-anzeigen.component';

describe('TipprundeAnzeigenComponent', () => {
  let component: TipprundeAnzeigenComponent;
  let fixture: ComponentFixture<TipprundeAnzeigenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipprundeAnzeigenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipprundeAnzeigenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
