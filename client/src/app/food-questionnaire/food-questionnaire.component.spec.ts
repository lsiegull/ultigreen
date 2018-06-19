import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodQuestionnaireComponent } from './food-questionnaire.component';

describe('FoodQuestionnaireComponent', () => {
  let component: FoodQuestionnaireComponent;
  let fixture: ComponentFixture<FoodQuestionnaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FoodQuestionnaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodQuestionnaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
