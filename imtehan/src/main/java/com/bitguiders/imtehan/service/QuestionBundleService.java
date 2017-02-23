/**
 * 
 */
package com.bitguiders.imtehan.service;

import java.util.List;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;

/**
 * @author yared
 *
 */
public interface QuestionBundleService {

	public List<QuestionBundleORM> getAllQuestionBundles();
	public QuestionBundleORM getQuestionBundle(int questionBundleId);
	
}
