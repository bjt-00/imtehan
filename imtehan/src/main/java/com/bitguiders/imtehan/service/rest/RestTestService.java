package com.bitguiders.imtehan.service.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;
import com.bitguiders.imtehan.service.rest.client.QuestionBundleRestClient;
import com.bitguiders.imtehan.service.rest.client.QuestionRestClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class RestTestService {
	
//	@Autowired
//	UserService service;
	
	@Autowired
	QuestionRestClient client;
	@Autowired
	QuestionBundleRestClient client2;

	@RequestMapping(value="/list", method=RequestMethod.GET )
	public @ResponseBody List<QuestionORM> getList(){
		List<QuestionORM> list = client.getList();
		for(QuestionORM orm :list){
			System.out.println("=> "+orm.getQuestion());
		}
		return client.getList();
	}
	@RequestMapping(value="/list2/{id}", method=RequestMethod.GET )
	public @ResponseBody List<QuestionORM> getList2(@PathVariable(value="id", required=false) int id){
		return client.getListByQuestionBundleId(id);
	}
	@RequestMapping(value="/select/{id}", method=RequestMethod.GET , produces="application/json")
	public @ResponseBody QuestionORM getOne(@PathVariable(value="id", required=false) int id){
		return (QuestionORM) client.getById(id);
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public @ResponseBody String add(){
		QuestionORM qb = new QuestionORM();
		qb.setQuestionBundleId(2);
		qb.setQuestion("Test Question");
		qb.setType("TF");
		qb.setFals(false);
		qb.setTru(true);
		//qb.setOptions("A,B");
		return client.add(qb);
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public @ResponseBody String update(@PathVariable(value="id", required=false) int id,HttpServletRequest request){
		QuestionORM qb = client.getById(id);
		qb.setQuestion("-"+qb.getQuestion());
		qb.setTru(true);
		return client.update(qb,request);
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable(value="id", required=false) int id){
		return client.delete(id);
	}
	
	 public static void main(String[] args) {
		       
			 String json = "{questionBundleId:\"1\",title:\"WAA Final Exam\",type:\"Exam\",date:\"03/02/2017\"}";
			 Gson gson = new GsonBuilder().create();
	            QuestionORM p = gson.fromJson(json, QuestionORM.class);
	            System.out.println(p.getQuestionId()+" "+p.getQuestion());

	       	 json = "[{questionBundleId:\"1\",title:\"WAA Final Exam\",type:\"Exam\",date:\"03/02/2017\"}"
	       		+",{questionBundleId:\"2\",title:\"WAA Final Exam\",type:\"Exam\",date:\"03/02/2017\"}]";

	       	 List<QuestionORM> list = (List<QuestionORM>) gson.fromJson(json, new TypeToken<ArrayList<QuestionORM>>() {
             }.getType());
	       	 for(QuestionORM qb:list)
	            System.out.println(qb.getQuestionId()+" "+qb.getQuestion());

	    }
	

	
}
