import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipprundecreateComponent } from './tipprundecreate.component';

describe('TipprundecreateComponent', () => {
  let component: TipprundecreateComponent;
  let fixture: ComponentFixture<TipprundecreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipprundecreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipprundecreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
