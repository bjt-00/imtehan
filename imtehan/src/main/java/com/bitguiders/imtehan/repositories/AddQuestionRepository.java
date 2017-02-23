package com.bitguiders.imtehan.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitguiders.imtehan.model.McqQuestion;
import com.bitguiders.imtehan.model.TrueFalseQestion;

@Repository
public interface AddQuestionRepository {

	public List<McqQuestion> getMcqQuestions();
	public List<TrueFalseQestion> getTrueFalseQuestions();
	public void addMcqQuestion(McqQuestion question);
	public void addTrueFalseQuestion(TrueFalseQestion question);
	
}
