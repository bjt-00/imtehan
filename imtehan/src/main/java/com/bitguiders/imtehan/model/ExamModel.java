package com.bitguiders.imtehan.model;

import java.util.List;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;
import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;

public class ExamModel  {
	int currentIndex=0;
	List<QuestionORM> questionsList;
	QuestionBundleORM exam;
	QuestionORM orm;
	double yourScore;
	double passingScore;
	boolean isFinished;
	int questionsLimit;
	
	public void setQuestions(List<QuestionORM> questionsList){
		this.questionsList = questionsList;
		questionsLimit = exam.getTotalQuestions();
		passingScore=0;
		yourScore=0;
	}
	public QuestionORM getNext(){
		orm = questionsList.get(currentIndex);
		if(currentIndex<questionsLimit-1){
			currentIndex++;
		}else{
			isFinished = true;
		}
		return orm;
	}
	public QuestionORM getOrm(){
		return orm;
	}
	public void setOrm(QuestionORM orm){
		this.orm = orm;
	}
	public QuestionORM getBack(){

		orm = questionsList.get(currentIndex);
		if(!isFinished && currentIndex>0){
			currentIndex--;
		}
		return orm;
	}

	public void setExam(QuestionBundleORM exam){
		currentIndex=0;
		this.exam = exam;
	}
	public QuestionBundleORM getExam(){
		return exam;
	}
	
	public int getcurrentIndex(){
		return currentIndex;
	}
	public List<QuestionORM> getQuestionsList(){
		return questionsList;
	}
	public double getPassingScore(){
		calculateScore();
		return passingScore;
	}
	public double getYourScore(){
		calculateScore();
		return yourScore;
	}
	public String getResult(){
		return (yourScore>=passingScore?"Pass":"Fail");
	}
	private void calculateScore(){
		if(passingScore==0){
		int correctQuestions=0;
		for(QuestionORM question:questionsList){
			if(question.getUserAnswer()==true){
				correctQuestions++;
			}
		}
		yourScore = correctQuestions*10;
		passingScore = questionsList.size()*10;
		}
	}
	public boolean isFinished(){
		return isFinished;
	}
	public int getQuestionsLimit() {
		return questionsLimit;
	}
	public void setQuestionsLimit(int questionsLimit) {
		for(int i=0;i<exam.getTotalQuestions()-questionsLimit;i++){
			questionsList.remove(i);
		}
		this.questionsLimit = questionsLimit;
	}
}
