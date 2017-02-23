package com.bitguiders.imtehan.model;

import java.util.List;

import com.bitguiders.imtehan.dataaccess.orm.OptionORM;
import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;
import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;

public class ExamModel  {
	int currentIndex=0;
	int totalQuestions;
	List<QuestionORM> questionsList;
	QuestionBundleORM exam;
	QuestionORM orm;
	
	public void setQuestions(List<QuestionORM> questionsList){
		this.questionsList = questionsList;
		totalQuestions=questionsList.size();
	}
	public QuestionORM getNext(){
		orm = questionsList.get(currentIndex);
		if(currentIndex<totalQuestions-1){
			currentIndex++;
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
		if(currentIndex>0){
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
	
	public int getTotalQuestions(){
		return totalQuestions;
	}
	public int getcurrentIndex(){
		return currentIndex;
	}
	public List<QuestionORM> getQuestionsList(){
		return questionsList;
	}
	public String getScore(){
		int totalQuestions = questionsList.size();
		int correctQuestions=0;
		for(QuestionORM question:questionsList){
			if(question.getUserAnswer()==true){
				correctQuestions++;
			}
		}
		return  correctQuestions*10+ " / "+totalQuestions*10;
	}
}
