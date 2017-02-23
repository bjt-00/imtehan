package com.bitguiders.imtehan.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.bitguiders.imtehan.model.ExamModel;
import com.bitguiders.imtehan.model.McqQuestion;
import com.bitguiders.imtehan.model.TrueFalseQestion;
import com.bitguiders.imtehan.service.AddQuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "addquestion")
public class AddQuestionController {

	@Autowired
	AddQuestionService addQuestionService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String welcome(
			@RequestParam(value = "questionType", required = false, defaultValue = "mcqzForm") String questionType,
			ModelMap model) {
		model.addAttribute("questionType", questionType);

		return "question/questionForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addQuestion(
			@RequestParam(value = "questionType", required = false, defaultValue = "mcqzForm") String questionType,
			ModelMap model) {
		model.addAttribute("questionType", questionType);

		return "question/questionForm";
	}

	@RequestMapping(value = "/addMcqQuestion", method = RequestMethod.POST)
	public String addMcsQuestion(@RequestParam("question") String question,
			@RequestParam("myOptions[]") String[] options,
			@RequestParam("answer") String answer) {

		McqQuestion mcqQuestion = new McqQuestion(question,
				Arrays.asList(options), answer);

		addQuestionService.addMcqQuestion(mcqQuestion);

		return null;
	}

	@RequestMapping(value = "/addTrueFalseQuestion", method = RequestMethod.POST)
	public String addTrueFalseQuestion(
			@RequestParam("question") String question,
			@RequestParam("answer") String answer) {

		TrueFalseQestion trueFalseQuestion = new TrueFalseQestion(question,
				answer.equals("true") ? true : false);

		addQuestionService.addTrueFalseQuestion(trueFalseQuestion);

		return null;
	}

	@RequestMapping(value = "/ttts/view/question/addMcqQuestion", method = RequestMethod.POST)
	public String home() {
		return "addMcqQuestion";

	}
}
