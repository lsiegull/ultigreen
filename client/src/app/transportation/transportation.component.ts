import { Component, OnInit } from '@angular/core';
import { TransportationQuestion } from '../transportationQuestion';

@Component({
  selector: 'app-transportation',
  templateUrl: './transportation.component.html',
  styleUrls: ['./transportation.component.css']
})
export class TransportationComponent implements OnInit {
  transportationQuestions: TransportationQuestion[] = [
    {id: 1, question: "How far away in miles do you live from work?", answer: "12"},
    {id: 2, question: "What is the mileage of your car?", answer: "40"},
    {id: 3, question: "How many people do you carpool with?", answer: "5"},
    {id: 4, question: "How many times/ week do you carpool to and from work?", answer: "10"}
  ];
  selectedQ: TransportationQuestion;
  
  constructor() { }

  ngOnInit() {
  }

  onSelect(transportationQ: TransportationQuestion): void {
    this.selectedQ = transportationQ;
  }

  ngOnClick(isPrevious: boolean): void {
    if (isPrevious) { //previous button
      alert("Previous screen");
    }else { //next button
      alert("Next screen");

    }
  }

}
