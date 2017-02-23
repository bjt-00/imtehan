package com.bitguiders.imtehan.model;

import java.util.List;

public class McqQuestion {

	private String question;
	private List<String> myOptions;
	private String answer;

	public McqQuestion() {

	}

	public McqQuestion(String question, List<String> myOptions, String answer) {
		this.question = question;
		this.myOptions = myOptions;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getMyOptions() {
		return myOptions;
	}

	public void setMyOptions(List<String> myOptions) {
		this.myOptions = myOptions;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
