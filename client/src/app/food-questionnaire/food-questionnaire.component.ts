import { Component, OnInit } from '@angular/core';
import { QuestionItem, ShortAnswer, Dropdown } from '../questionItem';

@Component({
  selector: 'app-food-questionnaire',
  templateUrl: './food-questionnaire.component.html',
  styleUrls: ['./food-questionnaire.component.css']
})
export class FoodQuestionnaireComponent implements OnInit {
  title: string = "Food";
  foodQuestions: QuestionItem[] = [
    <ShortAnswer> {id: 1, question: "How many grams of lamb do you consume in 1 day?\n (100 grams of meat can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 2, question: "How many grams of beef do you consume in 1 day?\n (100 grams of meat can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 3, question: "How many grams of pork do you consume in 1 day?\n (100 grams of meat can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 4, question: "How many grams of turkey do you consume in 1 day?\n (100 grams of meat can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 5, question: "How many grams of chicken do you consume in 1 day?\n (100 grams of meat can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 6, question: "How many grams of tuna do you consume in 1 day?\n (100 grams of meat can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 7, question: "How many grams of eggs do you consume in 1 day?\n (An egg is about 50 grams).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 8, question: "How many grams of potato do you consume in 1 day?\n (A medium-sized potato is about 200 grams).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 9, question: "How many grams of rice do you consume in 1 day?\n (100 grams of rice is approximately the size of the front of your clenched fist).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 10, question: "How many grams of nuts do you consume in 1 day?\n (20 grams of nuts can fit in one palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 11, question: "How many grams of beans do you consume in 1 day?\n (4 grams of beans can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 12, question: "How many grams of tofu do you consume in 1 day?\n (6 grams of tofu can fit in your palm).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 13, question: "How many grams of vegetables do you consume in 1 day?\n (80 grams of uncooked vegetables could fit in two handfuls).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 14, question: "How many grams of milk do you consume in 1 day?\n (1 cup of milk has 250 grams).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 15, question: "How many grams of fruit do you consume in 1 day?\n (A medium-sized apple is about 200 grams).", answer: "0", type: "ShortAnswer"},
    <ShortAnswer> {id: 16, question: "How many grams of cheese do you consume in 1 day?\n (30 grams of cheese is the size of two thumbs).", answer: "0", type: "ShortAnswer"}  
  ];
  prevPage = "";
  nextPage = "reusable-dishware-questionnaire";

  constructor() { }

  ngOnInit() {
  }

}
