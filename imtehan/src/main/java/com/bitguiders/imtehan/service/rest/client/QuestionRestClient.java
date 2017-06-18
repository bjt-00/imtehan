package com.bitguiders.imtehan.service.rest.client;

import java.util.List;

import com.bitguiders.imtehan.dataaccess.orm.QuestionORM;


public abstract class QuestionRestClient extends GenericRestClient<QuestionORM> {
	QuestionRestClient(RestClientSupport.REST service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	public abstract List<QuestionORM> getListByQuestionBundleId(int id);

}
