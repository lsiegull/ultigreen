import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questionnaire-results',
  templateUrl: './questionnaire-results.component.html',
  styleUrls: ['./questionnaire-results.component.css']
})
export class QuestionnaireResultsComponent implements OnInit {
  foodFootprint: string = "5200";
  reusableDishwareFootprint: string = "3400";
  transportationFootprint: string = "8600";
  totalFootprint: string = String(Number(this.foodFootprint) + Number(this.reusableDishwareFootprint) + Number(this.transportationFootprint));

  constructor() { }

  ngOnInit() {
  }

}
