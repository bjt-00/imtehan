package com.bitguiders.imtehan.model;

public class TrueFalseQestion {

	private String question;
	private boolean answer;

	public TrueFalseQestion() {
	}

	public TrueFalseQestion(String question, boolean answer) {
		
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

}
