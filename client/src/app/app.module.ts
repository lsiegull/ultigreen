import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend

import { AppComponent }  from './app.component';
import { routing }        from './app.routing';

import { AlertComponent } from './directives';
import { AuthGuard } from './guards';
import { JwtInterceptor } from './helpers';
import { AlertService, AuthenticationService, UserService } from './services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { FoodComponent } from './food/food.component';
import { TransportationComponent } from './transportation/transportation.component';
import { ReusableItemsComponent } from './reusable-items/reusable-items.component';
import { TransportationQuestionnaireComponent } from './transportation-questionnaire/transportation-questionnaire.component';
import { QuestionnairePageComponent } from './questionnaire-page/questionnaire-page.component';
import { ReusableDishwareQuestionnaireComponent } from './reusable-dishware-questionnaire/reusable-dishware-questionnaire.component';
import { FoodQuestionnaireComponent } from './food-questionnaire/food-questionnaire.component';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        routing
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent,
        FoodComponent,
        TransportationComponent,
        ReusableItemsComponent,
        TransportationQuestionnaireComponent,
        QuestionnairePageComponent,
        ReusableDishwareQuestionnaireComponent,
        FoodQuestionnaireComponent
    ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: JwtInterceptor,
            multi: true
        }
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }