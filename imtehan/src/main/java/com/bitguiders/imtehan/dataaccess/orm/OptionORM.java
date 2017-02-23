package com.bitguiders.imtehan.dataaccess.orm;

public class OptionORM {

	private String optionLabel;
	private boolean isCorrect;
	private boolean userAnswer;
	
	public OptionORM(){}
	public OptionORM(String optionLabel,boolean isCorrect){
		this.optionLabel = optionLabel;
		this.isCorrect = isCorrect;
	}
	
	public String getOptionLabel() {
		return optionLabel;
	}
	public void setOptionLabel(String optionLabel) {
		this.optionLabel = optionLabel;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public boolean isUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(boolean userAnswer) {
		this.userAnswer = userAnswer;
		System.out.println("------New ans rcvd = "+userAnswer);
	}
}
