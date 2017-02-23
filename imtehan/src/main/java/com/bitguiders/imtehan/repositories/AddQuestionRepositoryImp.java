package com.bitguiders.imtehan.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitguiders.imtehan.model.McqQuestion;
import com.bitguiders.imtehan.model.TrueFalseQestion;

@Repository
public class AddQuestionRepositoryImp implements AddQuestionRepository {

	List<McqQuestion> ListMcq;
	List<TrueFalseQestion> ListTrueFalse;

	public AddQuestionRepositoryImp() {
		ListMcq = new ArrayList<>();
		ListTrueFalse = new ArrayList<>();

	}

	@Override
	public List<McqQuestion> getMcqQuestions() {
		return ListMcq;
	}

	@Override
	public List<TrueFalseQestion> getTrueFalseQuestions() {
		return ListTrueFalse;
	}

	@Override
	public void addMcqQuestion(McqQuestion question) {
		ListMcq.add(question);
		System.out.println(ListMcq);

	}

	@Override
	public void addTrueFalseQuestion(TrueFalseQestion question) {
		ListTrueFalse.add(question);
	}

}
