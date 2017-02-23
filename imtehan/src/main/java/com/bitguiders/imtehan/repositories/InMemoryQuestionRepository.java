/**
 * 
 */
package com.bitguiders.imtehan.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitguiders.imtehan.model.Answer;
import com.bitguiders.imtehan.model.Question;

/**
 * @author yared
 *
 */


@Repository
public class InMemoryQuestionRepository implements QuestionRepository {

	
	private List<Question> questionList;


	
	public InMemoryQuestionRepository(){
		
		questionList = new ArrayList<Question>();
		
		Question q1 = new Question();
		Question q2 = new Question();
		Question q3 = new Question();
		
		Answer a1 = new Answer(q1, "Answer : Inheritance");
		Answer a2 = new Answer(q2, "Answer : Spring IOC");
		Answer a3 = new Answer(q3, "Answer : Polymorphism");
		
		q1.setQuestionId(1);
		q2.setQuestionId(2);
		q3.setQuestionId(3);
		
		
		q1.setQuestionText("Inheritance in Java?");
		q2.setQuestionText("Spring IoC and Dependency Injection?");
		q1.setQuestionText("Poloymorphism in Java?");
		
		q1.setCorrectAnswer(a1);
		q2.setCorrectAnswer(a2);
		q3.setCorrectAnswer(a3);
		
		questionList.add(q1);
		questionList.add(q2);
		questionList.add(q3);
	}
	
	@Override
	public List<Question> getAllQuestion() {		
		return this.questionList;		
	}

}
