/**
 * 
 */
package com.bitguiders.imtehan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.bitguiders.imtehan.dataaccess.orm.OptionORM;
import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;
import com.bitguiders.imtehan.service.rest.client.QuestionBundleRestClient;
import com.bitguiders.imtehan.service.rest.client.QuestionRestClient;

/**
 * @author yared
 *
 */

//@Controller(value="/testle")
@Controller
@SessionScope
@SessionAttributes("qorm")
@RequestMapping(value="q")
public class QuestionController extends GenericController {

	@Autowired
	QuestionRestClient client;
	
	@Autowired
	QuestionBundleRestClient client2;
	
	
	//Information about the Questionle form
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getList(@RequestParam(value="qbid", required=false) int qbid,
			ModelMap model)
	{
		model.addAttribute("questionList",client.getListByQuestionBundleId(qbid));
		model.addAttribute("qbid",qbid);
		model.addAttribute("qb",client2.getById(qbid));
		
		return getView("question/questionList",model);
	}
	
	//Information about the Questionle form
	@RequestMapping(value="/add",method=RequestMethod.GET )
	public String add(@RequestParam(value="qbid", required=false) int qbid,@RequestParam(value="questionType", defaultValue="mcqzForm") String questionType,ModelMap model)
	{
		QuestionORM orm = new QuestionORM();
		orm.setQuestionBundleId(qbid);
		orm.setType("mcqzForm");
		model.addAttribute("action","save");
		model.addAttribute("qorm",orm);
		model.addAttribute("questionType",questionType);
		return getView("question/questionForm",model);
	}
	@RequestMapping(value="/addOption",method=RequestMethod.POST )
	public String addOption(@RequestParam(value="action", required=false) String action,ModelMap model,@ModelAttribute("qorm")QuestionORM orm)
	{
		List<OptionORM> optionsList = orm.getOptionsList();
		optionsList.add(new OptionORM());
		orm.setOptionsList(optionsList);
		model.addAttribute("action",action);
		model.addAttribute("qorm",orm);
		model.addAttribute("qbid",orm.getQuestionBundleId());
		return getView("question/questionForm",model);
	}

	@RequestMapping(value="/questionType",method=RequestMethod.POST )
	public String questionType(@RequestParam(value="type", defaultValue="mcqzForm") String type
			,ModelMap model,@ModelAttribute("qorm")QuestionORM orm)
	{
		model.addAttribute("action","save");
		orm.setType(type);
		model.addAttribute("qorm",orm);
		model.addAttribute("qbid",orm.getQuestionBundleId());
		return getView("question/questionForm",model);
	}
	@RequestMapping(value="/save",method=RequestMethod.POST )
	public String save(ModelMap model,@ModelAttribute("qorm")QuestionORM orm,HttpServletRequest request)
	{
		client.add(orm,request);
		
		//update total count for qb, its temp solution
		client2.update(client2.getById(orm.getQuestionBundleId()),request);
		
		setMessage("Question Saved Successfully",model);
		return getList(orm.getQuestionBundleId(),model);
		
	}
		
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	   public String edit(@RequestParam int id,ModelMap model) {
	       model.addAttribute("qorm",client.getById(id));
	       model.addAttribute("action","update");
	       return getView("question/questionForm",model);
	   }
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	   public String update(@Valid @ModelAttribute("qorm")QuestionORM orm,ModelMap model,
			   HttpServletRequest request) {
	       client.update(orm,request);
	       setMessage("Question updated successfully", model);
	       return getList(orm.getQuestionBundleId(),model);
	   }
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	   public String delete(@RequestParam int id,ModelMap model,HttpServletRequest request) {
		 QuestionORM orm = client.getById(id);
			 client.delete(id);
			 
				//update total count for qb, its temp solution
				client2.update(client2.getById(orm.getQuestionBundleId()),request);

				setMessage("Selected Question  deleted successfully",model);
				return getList(orm.getQuestionBundleId(), model);
	   }
}
