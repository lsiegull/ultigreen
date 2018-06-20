import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questionnaire-results',
  templateUrl: './questionnaire-results.component.html',
  styleUrls: ['./questionnaire-results.component.css']
})
export class QuestionnaireResultsComponent implements OnInit {
  foodFootprint: string = "132";
  reusableDishwareFootprint: string = "61";
  transportationFootprint: string = "83";
  totalFootprint: string = String(Number(this.foodFootprint) + Number(this.reusableDishwareFootprint) + Number(this.transportationFootprint));

  constructor() { }

  ngOnInit() {
  }

}
