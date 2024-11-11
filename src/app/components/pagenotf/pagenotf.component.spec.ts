import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagenotfComponent } from './pagenotf.component';

describe('PagenotfComponent', () => {
  let component: PagenotfComponent;
  let fixture: ComponentFixture<PagenotfComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PagenotfComponent]
    });
    fixture = TestBed.createComponent(PagenotfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
