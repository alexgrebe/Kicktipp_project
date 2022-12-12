import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipprundenlisteComponent } from './tipprundenliste.component';

describe('TipprundenlisteComponent', () => {
  let component: TipprundenlisteComponent;
  let fixture: ComponentFixture<TipprundenlisteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipprundenlisteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipprundenlisteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
