import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransportationQuestionnaireComponent } from './transportation-questionnaire.component';

describe('TransportationQuestionnaireComponent', () => {
  let component: TransportationQuestionnaireComponent;
  let fixture: ComponentFixture<TransportationQuestionnaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransportationQuestionnaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransportationQuestionnaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
