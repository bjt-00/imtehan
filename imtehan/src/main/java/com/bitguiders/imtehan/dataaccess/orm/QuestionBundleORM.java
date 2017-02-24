package com.bitguiders.imtehan.dataaccess.orm;

import java.io.Serializable;

public class QuestionBundleORM  implements Serializable{

	private int questionBundleId;
	private String title;
	private String type;
	private String technology;
	private String date;
	private String testingId;
	private String registrationId;
	private int totalQuestions;

	public int getQuestionBundleId() {
		return questionBundleId;
	}
	public void setQuestionBundleId(int questionBundleId) {
		this.questionBundleId = questionBundleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTestingId() {
		return testingId;
	}
	public void setTestingId(String testingId) {
		this.testingId = testingId;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

}
