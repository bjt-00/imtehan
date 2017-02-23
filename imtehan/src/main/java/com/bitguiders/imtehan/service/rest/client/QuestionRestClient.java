package com.bitguiders.imtehan.service.rest.client;

import java.util.List;

import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;


public interface QuestionRestClient extends GenericRestClient<QuestionORM> {
	public List<QuestionORM> getListByQuestionBundleId(int id);

}
