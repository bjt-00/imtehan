package com.bitguiders.imtehan.model;

public class Answer {

	
	private int answerId;
	private Question questionId;
	private String answerTextualDescription;
	
	public Answer(Question qid, String answerText){
		this.questionId = qid;
		this.answerTextualDescription = answerText;
	}
	
	public Answer(int answerId, Question questionId, String answerTextualDescription) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.answerTextualDescription = answerTextualDescription;
	}
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public Question getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}
	public String getAnswerTextualDescription() {
		return answerTextualDescription;
	}
	public void setAnswerTextualDescription(String answerTextualDescription) {
		this.answerTextualDescription = answerTextualDescription;
	}

	
}
