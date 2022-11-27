import {ComponentFixture, TestBed} from '@angular/core/testing';

import {SpieleComponent} from './spiele.component';

describe('SpieleComponent', () => {
  let component: SpieleComponent;
  let fixture: ComponentFixture<SpieleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SpieleComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(SpieleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
