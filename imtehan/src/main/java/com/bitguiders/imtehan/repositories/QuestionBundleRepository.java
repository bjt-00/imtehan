/**
 * 
 */
package com.bitguiders.imtehan.repositories;

import java.util.List;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;

/**
 * @author yared
 *
 */
public interface QuestionBundleRepository {
	public List<QuestionBundleORM> getAllQuestionBundles();
	public QuestionBundleORM getQuestionBundle(int questionBundleId);
}
