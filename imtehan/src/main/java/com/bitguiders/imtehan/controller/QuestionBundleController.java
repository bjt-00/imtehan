/**
 * 
 */
package com.bitguiders.imtehan.controller;

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

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;
import com.bitguiders.imtehan.service.rest.client.QuestionBundleRestClient;

/**
 * @author Abdul Kareem
 *
 */

//@Controller(value="/testBundle")
@Controller
@SessionScope
@SessionAttributes("qborm")
@RequestMapping(value="qb")
public class QuestionBundleController extends GenericController {

	@Autowired
	QuestionBundleRestClient client;
	
	
	
	//Information about the QuestionBundle form
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getList(ModelMap model)
	{
		model.addAttribute("bundleList",client.getList());
		
		return getView("question/quetionBundleList",model);
	}
	
	//Information about the QuestionBundle form
	@RequestMapping(value="/add",method=RequestMethod.GET )
	public String add(ModelMap model)
	{
		model.addAttribute("action","save");
		model.addAttribute("qborm",new QuestionBundleORM());
		return getView("question/questionBundleForm",model);
	}
	@RequestMapping(value="/save",method=RequestMethod.POST )
	public String save(ModelMap model,@ModelAttribute("qborm")QuestionBundleORM orm)
	{
		client.add(orm);
		model.addAttribute("bundleList",client.getList());
		return getView("question/quetionBundleList",model,orm.getTitle()+" Saved Successfully");
	}
		
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	   public String edit(@RequestParam int id,ModelMap model) {
	       QuestionBundleORM orm = client.getById(id);
	       model.addAttribute("qborm",orm);
	       model.addAttribute("action","update");
	       return getView("question/questionBundleForm",model);
	   }
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	   public String update(@Valid @ModelAttribute("qborm")QuestionBundleORM orm,ModelMap model,HttpServletRequest request) {
	       setMessage(client.update(orm,request),model);
			model.addAttribute("bundleList",client.getList());
	       return getView("question/quetionBundleList",model);
	   }

	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	   public String delete(@RequestParam int id,ModelMap model) {
		 model.addAttribute("action","delete");
			 client.delete(id);
			 model.addAttribute("id",id);
			model.addAttribute("bundleList",client.getList());
			return getView("question/quetionBundleList",model,"Selected Question Bundle deleted successfully");
	   }
		
}
