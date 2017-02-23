package com.bitguiders.imtehan.model;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;

public class QuestionBundle {

	private QuestionBundleORM orm;
	String test;

	public QuestionBundleORM getOrm(){
		if(null==orm){
			orm = new QuestionBundleORM();
		}
		return orm;
	}
	public void setOrm(QuestionBundleORM orm){
		this.orm=orm;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	
}
