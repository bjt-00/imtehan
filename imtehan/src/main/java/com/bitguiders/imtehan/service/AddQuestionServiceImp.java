package com.bitguiders.imtehan.service;

import java.util.List;

import com.bitguiders.imtehan.model.McqQuestion;
import com.bitguiders.imtehan.model.TrueFalseQestion;
import com.bitguiders.imtehan.repositories.AddQuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddQuestionServiceImp implements AddQuestionService {

	@Autowired
	AddQuestionRepository addQuestionRepository;

	@Override
	public List<McqQuestion> getMcqQuestions() {
		return addQuestionRepository.getMcqQuestions();
	}

	@Override
	public List<TrueFalseQestion> getTrueFalseQuestions() {

		return addQuestionRepository.getTrueFalseQuestions();
	}

	@Override
	public void addMcqQuestion(McqQuestion question) {
		addQuestionRepository.addMcqQuestion(question);

	}

	@Override
	public void addTrueFalseQuestion(TrueFalseQestion question) {
		addQuestionRepository.addTrueFalseQuestion(question);

	}

}
