import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TransportationComponent } from './transportation/transportation.component';
import { QuestionnairePageComponent } from './questionnaire-page/questionnaire-page.component';

@NgModule({
  declarations: [
    AppComponent,
    TransportationComponent,
    QuestionnairePageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
