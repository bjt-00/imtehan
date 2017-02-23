/**
 * 
 */
package com.bitguiders.imtehan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;
import com.bitguiders.imtehan.repositories.QuestionBundleRepository;

/**
 * @author yared
 *
 */

@Service
public class QuestionBundleServiceImpl implements QuestionBundleService {

	
	@Autowired	
	private QuestionBundleRepository qbRepo;
	
		
	@Override
	public List<QuestionBundleORM> getAllQuestionBundles() {		
		return qbRepo.getAllQuestionBundles();
	}

	@Override
	public QuestionBundleORM getQuestionBundle(int questionBundleId) {	
		return qbRepo.getQuestionBundle(questionBundleId);
	}

}
