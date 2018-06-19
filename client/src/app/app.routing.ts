import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AuthGuard } from './guards';
import { FoodQuestionnaireComponent } from './food-questionnaire/food-questionnaire.component';
import { ReusableDishwareQuestionnaireComponent } from './reusable-dishware-questionnaire/reusable-dishware-questionnaire.component';
import { TransportationQuestionnaireComponent } from './transportation-questionnaire/transportation-questionnaire.component';

const appRoutes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'food-questionnaire', component: FoodQuestionnaireComponent },
    { path: 'reusable-dishware-questionnaire', component: ReusableDishwareQuestionnaireComponent },
    { path: 'transportation-questionnaire', component: TransportationQuestionnaireComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);