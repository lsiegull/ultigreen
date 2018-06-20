import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questionnaire-results',
  templateUrl: './questionnaire-results.component.html',
  styleUrls: ['./questionnaire-results.component.css']
})
export class QuestionnaireResultsComponent implements OnInit {
  foodFootprint: string = "13";
  reusableDishwareFootprint: string = "10";
  transportationFootprint: string = "20";
  totalFootprint: string = "78";

  constructor() { }

  ngOnInit() {
  }

}
