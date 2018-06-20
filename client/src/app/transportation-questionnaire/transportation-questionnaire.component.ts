import { Component, OnInit } from '@angular/core';
import { QuestionItem, ShortAnswer, Dropdown } from '../questionItem';

@Component({
  selector: 'app-transportation-questionnaire',
  templateUrl: './transportation-questionnaire.component.html',
  styleUrls: ['./transportation-questionnaire.component.css']
})
export class TransportationQuestionnaireComponent implements OnInit {
  title: string = "Transportation";
  transportationQuestions: QuestionItem[] = [
    <ShortAnswer> {id: 1, question: "How far away in miles do you live from work?", answer: "0", type:"ShortAnswer"},
    <ShortAnswer> {id: 2, question: "What is the mileage of your car?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 3, question: "How many people do you carpool with?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 4, question: "How many times/ week do you carpool to and from work?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 5, question: "How many times/ week do you bus to and from work?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 6, question: "How many times/ week do you bike or walk to and from work?", answer: "0", type: "ShortAnswer"}
  ];
  selectedQ: QuestionItem;
  prevPage = "reusable-dishware-questionnaire";

  nextPage = "questionnaire-results";

  constructor() { }

  ngOnInit() {
  }

}
