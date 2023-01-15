import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WettenligaComponent } from './wettenliga.component';

describe('WettenligaComponent', () => {
  let component: WettenligaComponent;
  let fixture: ComponentFixture<WettenligaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WettenligaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WettenligaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
