package com.bitguiders.imtehan.service;

import java.util.List;

import com.bitguiders.imtehan.model.McqQuestion;
import com.bitguiders.imtehan.model.TrueFalseQestion;

import org.springframework.stereotype.Service;

@Service
public interface AddQuestionService {

	public List<McqQuestion> getMcqQuestions();

	public List<TrueFalseQestion> getTrueFalseQuestions();

	public void addMcqQuestion(McqQuestion question);

	public void addTrueFalseQuestion(TrueFalseQestion question);

}
