import { Component, OnInit } from '@angular/core';
import { QuestionItem, ShortAnswer, Dropdown } from '../questionItem';

@Component({
  selector: 'app-transportation',
  templateUrl: './transportation.component.html',
  styleUrls: ['./transportation.component.css']
})
export class TransportationComponent implements OnInit {
  title: string = "Transportation";
  transportationQuestions: QuestionItem[] = [
    <ShortAnswer> {id: 1, question: "How far away in miles do you live from work?", answer: "12", type:"ShortAnswer"},
    <ShortAnswer> {id: 2, question: "What is the mileage of your car?", answer: "40", type: "ShortAnswer"},
    <ShortAnswer> {id: 3, question: "How many people do you carpool with?", answer: "5", type: "ShortAnswer"},
    <ShortAnswer> {id: 4, question: "How many times/ week do you carpool to and from work?", answer: "10", type: "ShortAnswer"},
    <ShortAnswer> {id: 5, question: "How many times/ week do you bus to and from work?", answer: "", type: "ShortAnswer"},
    <ShortAnswer> {id: 6, question: "How many times/ week do you bike or walk to and from work?", answer: "", type: "ShortAnswer"}
  ];
  selectedQ: QuestionItem;
  
  constructor() { }

  ngOnInit() {
  }

}
