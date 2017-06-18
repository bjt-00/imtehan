package com.bitguiders.imtehan.service.rest.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.gson.reflect.TypeToken;

import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;
import com.bitguiders.imtehan.util.QuestionParser;

@Service
public class QuestionRestClientImpl extends QuestionRestClient {

	public QuestionRestClientImpl(){
		super(REST.QUESTION);
	}
	
	@Override
	public QuestionORM getById(int id) {
		QuestionORM question =gson.fromJson(getJson(service.getSelectURL(id)), QuestionORM.class);
         return format(question);
	}

	@Override
	public String add(QuestionORM qb,HttpServletRequest request) {
		ResponseEntity<String> response = restTemplate.postForEntity( service.getAddURL(), request , String.class );
		return response.getBody();//restTemplate.getForObject( service.getAddURL(toSQL(qb)), String.class);
	}
	@Override
	public String update(QuestionORM qb,HttpServletRequest request) {
		ResponseEntity<String> response = restTemplate.postForEntity( service.getUpdateURL(qb.getQuestionId(),""), request , String.class );
		return response.getBody();
	}

	@Override
	public String toUpdate(QuestionORM qb) {
		return "question='" + QuestionParser.parse(qb.getQuestion()) + "', type='" + qb.getType() + "',options = '"+QuestionParser.parse(qb.getOptions())+"'";
	}
	
	private QuestionORM format(QuestionORM question){
		question.setQuestion(QuestionParser.format(question.getQuestion()));
		
		question.getOptionsList();
		question.setOptions(QuestionParser.format(question.getOptions()));
		
		return question;
	}
	private List<QuestionORM> format(List<QuestionORM> questions){
     	 for(QuestionORM question:questions){
      		 format(question);
      	 }
      	 return questions;

	}
	@Override
	public String toSQL(QuestionORM qb) {
		return "(questionId,questionBundleId,question,type,options)"
	+" VALUES(0,"+qb.getQuestionBundleId()+",'" +QuestionParser.parse(qb.getQuestion()) + "','" + qb.getType()+ "','"+QuestionParser.parse(qb.getOptions())+ "')";
	}

	public List<QuestionORM> getList() {
		String json = getJson(service.getListURL());
		if(null!=json && !json.equals("")){
		List<QuestionORM> questions=  gson.fromJson(json, new TypeToken<ArrayList<QuestionORM>>() {
         }.getType());
      	 return format(questions);
		}else{
			return new ArrayList<QuestionORM>();
		}

	}
	public List<QuestionORM> getListByQuestionBundleId(int id) {
		String json = getJson(service.getListURL(id));
		if(null!=json && !json.equals("")){
			List<QuestionORM> questions= gson.fromJson(json, new TypeToken<ArrayList<QuestionORM>>() {
         }.getType());
			return format(questions);
		}else{
			return new ArrayList<QuestionORM>();
		}

	}


public static void main(String[] arg){
	System.out.println(QuestionParser.parse("{}}"));
}

@Override
public String delete(QuestionORM e, HttpServletRequest request) {
	// TODO Auto-generated method stub
	return null;
}



}
