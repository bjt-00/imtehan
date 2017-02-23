package com.bitguiders.imtehan.service.rest.client;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;

public class QuestionBundleRestClientTest {

	@Autowired
	QuestionBundleRestClient client;

	@Test
	public void addTest() {
		QuestionBundleORM expected = new QuestionBundleORM();
		
		expected.setQuestionBundleId(1);
		expected.setType("Test-Type");
		expected.setTitle("Test-Title");
		
		String message = client.add(expected);
		
		QuestionBundleORM found = client.getById(1);
		
		assertTrue("Oops add operation failed :"+message,found != null 
				&& found.getTitle().equals(expected.getTitle()) 
				&& found.getType().equals(expected.getType()));
	}
	@Test
	public void updateTest() {
		QuestionBundleORM expected = new QuestionBundleORM();
		
		expected.setQuestionBundleId(1);
		expected.setType("-Test-Type");
		expected.setTitle("-Test-Title");
		
		//client.update(expected);
		
		QuestionBundleORM found = client.getById(1);
		
		assertTrue(found != null 
				&& found.getTitle().equals(expected.getTitle()) 
				&& found.getType().equals(expected.getType()));
	}
	@Test
	public void deleteTest() {
		client.delete(1);
		QuestionBundleORM found = client.getById(1);
		assertTrue(found == null );
	}

}
