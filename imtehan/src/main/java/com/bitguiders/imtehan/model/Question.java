/**
 * 
 */
package com.bitguiders.imtehan.model;

import java.util.List;

/**
 * @author yared
 *
 */
public class Question {

	
	 private enum QuestionType{
		 TRUE_FALSE,
		 MULTIPLE_CHOICE
	 }
	
	 private int questionId;
	 private String questionText;
	 private List<Answer> possibleAnswers;
	 private Answer correctAnswer;
	 private QuestionType type;
	 
	
	 
	
	public int getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<Answer> getPossibleAnswers() {
		return possibleAnswers;
	}
	public void setPossibleAnswers(List<Answer> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	public Answer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public QuestionType getType() {
		return type;
	}
	public void setType(QuestionType type) {
		this.type = type;
	}
}
