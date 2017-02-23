/**
 * 
 */
package com.bitguiders.imtehan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitguiders.imtehan.model.Question;
import com.bitguiders.imtehan.repositories.QuestionRepository;


/**
 * @author yared
 *
 */

@Service
public class QuestionServiceImpl implements QuestionService {

	
	@Autowired
	QuestionRepository questionRepository;


	@Override
	public List<Question> getAllQuestion() {
		return this.questionRepository.getAllQuestion();
	}
	
	
}
