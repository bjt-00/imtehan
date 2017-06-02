package com.bitguiders.imtehan.service.rest.client;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;

//integration with JUnit
@RunWith(MockitoJUnitRunner.class)
public class QuestionBundleRestClientTest {

	//@Autowired
	@InjectMocks
	QuestionBundleORM orm = new QuestionBundleORM();

	@InjectMocks
	QuestionBundleORM expected = new QuestionBundleORM();
	
	@Mock
	QuestionBundleRestClient client;

	@Before
	public void setup(){
		//client = Mockito.mock(QuestionBundleRestClient.class);
		
		
		orm.setQuestionBundleId(1);
		orm.setType("Test-Type");
		orm.setTitle("Test-Title");
		
	}
	
	@Test
	public void addTest() {
		
		expected.setQuestionBundleId(1);
		expected.setType("Test-Type");
		expected.setTitle("Test-Title");
		
		//add behaviour
		when(client.add(expected)).thenReturn("success");
		String message = client.add(expected);
		
		//add behaviour
		when(client.getById(1)).thenReturn(orm);
		QuestionBundleORM found = client.getById(1);

		assertTrue("Oops add operation failed :"+message,found != null 
				&& found.getTitle().equals(expected.getTitle()) 
				&& found.getType().equals(expected.getType()));
		
		//verify if defined behaviour method is called or not
		verify(client).add(expected);
		//verify(client,times(2)).add(expected);
		//verify(client,never()).add(expected);
		//verify(client,atLeastOne..atMost(2) etc).add(expected);
		//
	}
	@Test
	public void updateTest() {
		
		expected.setQuestionBundleId(1);
		expected.setType("-Test-Type");
		expected.setTitle("-Test-Title");
		
		//add behaviour
		when(client.update(expected,null)).thenReturn("success");

		client.update(expected,null);
		
		//add behaviour
		when(client.getById(1)).thenReturn(expected);

		QuestionBundleORM found = client.getById(1);
		
		assertTrue(found != null 
				&& found.getTitle().equals(expected.getTitle()) 
				&& found.getType().equals(expected.getType()));
		
		verify(client).update(expected,null);
	}
	@Test
	public void deleteTest() {
		client.delete(1);
		QuestionBundleORM found = client.getById(1);
		assertTrue(found == null );
	}

}
