package com.bitguiders.imtehan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;
import com.bitguiders.imtehan.model.ExamModel;
import com.bitguiders.imtehan.service.rest.client.QuestionBundleRestClient;
import com.bitguiders.imtehan.service.rest.client.QuestionRestClient;

@Controller
@SessionScope
@SessionAttributes({"examModel","qorm"})
@RequestMapping(value="exam")
public class ExamController  extends GenericController {

	@Autowired
	QuestionRestClient client;
	
	@Autowired
	QuestionBundleRestClient qbClient;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String startExam(@RequestParam(value="id", required=false, defaultValue="2")int id, HttpServletRequest request, ModelMap model
			) {
		ExamModel examModel = new ExamModel();
		examModel.setExam(qbClient.getById(id));
	
		model.addAttribute("examModel",examModel);
		examModel.setQuestions(client.getListByQuestionBundleId(examModel.getExam().getQuestionBundleId()));
		return getView("exam/startExam",model);

	}

//	int index = 0;

	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public String examForm(HttpServletRequest request, HttpSession session,
			ModelMap model,@ModelAttribute ExamModel examModel,@RequestParam(value="questionsLimit", required=false, defaultValue="0")int questionsLimit) {

		
		examModel.setQuestions(client.getListByQuestionBundleId(examModel.getExam().getQuestionBundleId()));
		if(questionsLimit>0){
			examModel.setQuestionsLimit(questionsLimit);
		}
		examModel.getNext();
		model.addAttribute("examModel",examModel);
		return getView("exam/examForm",model,"Best of luck :) ");
	}
	@RequestMapping(value = "/next", method = RequestMethod.POST)
	public String next(HttpServletRequest request, HttpSession session,
			ModelMap model,@ModelAttribute ExamModel examModel) {
		model.addAttribute("examModel",examModel);
		if(examModel.isFinished()){
			return resultList(request,model,examModel);
		}
		examModel.getNext();
		return getView("exam/examForm",model);
	}
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public String back(HttpServletRequest request, HttpSession session,
			ModelMap model,@ModelAttribute ExamModel examModel) {
		model.addAttribute("examModel",examModel);
		examModel.getBack();
		return getView("exam/examForm",model);
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String resultList(HttpServletRequest request, 
			ModelMap model,@ModelAttribute ExamModel examModel) {
		model.addAttribute("examModel",examModel);
		return getView("exam/resultList",model,"Exam is over now");
	}


}
