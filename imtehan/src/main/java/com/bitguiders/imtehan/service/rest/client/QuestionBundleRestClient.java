package com.bitguiders.imtehan.service.rest.client;

import org.springframework.stereotype.Service;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;

@Service
public abstract class QuestionBundleRestClient extends GenericRestClient<QuestionBundleORM> {

	QuestionBundleRestClient(RestClientSupport.REST service) {
		super(service);
	}
	
}
