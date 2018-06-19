import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TransportationQuestionnaireComponent } from './transportation-questionnaire/transportation-questionnaire.component';
import { QuestionnairePageComponent } from './questionnaire-page/questionnaire-page.component';
import { ReusableDishwareQuestionnaireComponent } from './reusable-dishware-questionnaire/reusable-dishware-questionnaire.component';
import { FoodQuestionnaireComponent } from './food-questionnaire/food-questionnaire.component';

@NgModule({
  declarations: [
    AppComponent,
    TransportationQuestionnaireComponent,
    QuestionnairePageComponent,
    ReusableDishwareQuestionnaireComponent,
    FoodQuestionnaireComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
