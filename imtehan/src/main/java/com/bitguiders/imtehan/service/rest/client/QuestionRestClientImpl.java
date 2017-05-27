package com.bitguiders.imtehan.service.rest.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;
import com.bitguiders.imtehan.util.QuestionParser;

@Service
public class QuestionRestClientImpl extends RestClientSupport<QuestionORM> implements QuestionRestClient {

	public QuestionRestClientImpl(){
		super(REST.QUESTION);
	}
	
	@Override
	public QuestionORM getById(int id) {
		QuestionORM question =gson.fromJson(getJson(service.getSelectURL(id)), QuestionORM.class);
         return format(question);
	}

	@Override
	public String add(QuestionORM qb) {
		System.out.println(toSQL(qb));
		return restTemplate.getForObject( service.getAddURL(toSQL(qb)), String.class);
	}
	@Override
	public String update(QuestionORM qb,HttpServletRequest request) {
		System.out.println(toUpdate(qb));
		return restTemplate.getForObject(service.getUpdateURL(qb.getQuestionId(),toUpdate(qb)), String.class);
		
        /*Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", qb.getQuestionId()+"");
        vars.put("data", toUpdate(qb));
        vars.put("a","update");


		return restTemplate.postForObject(service.getUpdateURL(qb.getQuestionId(),""),request, String.class,vars);
*/	}

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

}
