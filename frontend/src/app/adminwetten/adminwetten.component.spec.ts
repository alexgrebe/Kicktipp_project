import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminwettenComponent } from './adminwetten.component';

describe('AdminwettenComponent', () => {
  let component: AdminwettenComponent;
  let fixture: ComponentFixture<AdminwettenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminwettenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminwettenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
