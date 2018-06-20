import { Component, OnInit } from '@angular/core';
import { QuestionItem, ShortAnswer, Dropdown } from '../questionItem';

@Component({
  selector: 'app-reusable-dishware-questionnaire',
  templateUrl: './reusable-dishware-questionnaire.component.html',
  styleUrls: ['./reusable-dishware-questionnaire.component.css']
})
export class ReusableDishwareQuestionnaireComponent implements OnInit {
  title: string = "Reusable Dishware";
  reusableQuestions: QuestionItem[] = [
    <ShortAnswer> {id: 1, question: "How many single-use styrofoam products do you use per day at work?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 2, question: "How many single-use plastic products do you use per day at work?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 3, question: "How many single-use bagasse (plant fiber from sugarcane or sorghum) products do you use per day at work?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 4, question: "How many single-use non-recycled paper products do you use per day at work?", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 5, question: "How many single-use recycled paper products do you use per day at work?", answer: "0", type: "ShortAnswer"}
  ];
  prevPage = "food-questionnaire";
  nextPage = "transportation-questionnaire";

  constructor() { }

  ngOnInit() {
  }

}







