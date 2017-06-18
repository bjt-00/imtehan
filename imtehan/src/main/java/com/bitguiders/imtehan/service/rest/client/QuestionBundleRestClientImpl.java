package com.bitguiders.imtehan.service.rest.client;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.gson.reflect.TypeToken;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;

@Service
public class QuestionBundleRestClientImpl extends QuestionBundleRestClient {

	public QuestionBundleRestClientImpl(){
		super(REST.QUESTION_UNDLE);
	}
	
	@Override
	public QuestionBundleORM getById(int id) {
         return gson.fromJson(getJson(service.getSelectURL(id)), QuestionBundleORM.class);
	}

	@Override
	public String add(QuestionBundleORM qb,HttpServletRequest request) {
		ResponseEntity<String> response = restTemplate.postForEntity(service.getURL(), getFormattedRequest(qb.getQuestionBundleId()+"",request), String.class);
		return response.getBody();
	}

	@Override
	public String update(QuestionBundleORM qb,HttpServletRequest request){
		ResponseEntity<String> response = restTemplate.postForEntity(service.getURL(), getFormattedRequest(qb.getQuestionBundleId()+"",request), String.class);
		return response.getBody();
	}

	@Override
	public String toUpdate(QuestionBundleORM qb) {
		return "title='" + qb.getTitle() + "', type='" + qb.getType() + "', technology='" + qb.getTechnology()+"', date='" + qb.getDate()+"', totalQuestions= (SELECT count(*) FROM question WHERE questionBundleId ="+qb.getQuestionBundleId()+")";
	}
	@Override
	public String toSQL(QuestionBundleORM qb) {
		return "(questionBundleId,title,type,technology,date,totalQuestions)"
	+" VALUES(0,'" + qb.getTitle() + "','" + qb.getType()+ "','" + qb.getTechnology() + "','" + qb.getDate() + "',(SELECT count(*) FROM question WHERE questionBundleId ="+qb.getQuestionBundleId()+"))";
	}
	public List<QuestionBundleORM> getList() {
		String json = getJson(service.getListURL());
		if(null!=json && !json.equals("")){
      	 return  gson.fromJson(json, new TypeToken<ArrayList<QuestionBundleORM>>() {
         }.getType());
		}else{
			return new ArrayList<QuestionBundleORM>();
		}
	}
	//SELECT title,type ,(SELECT count(*) FROM question WHERE questionBundleId =qb.questionBundleId) FROM `question_bundle` qb WHERE 1

	@Override
	public String delete(QuestionBundleORM qb,HttpServletRequest request) {
		ResponseEntity<String> response = restTemplate.postForEntity(service.getURL(), getFormattedRequest(qb.getQuestionBundleId()+"",request), String.class);
		return response.getBody();
	}
}
