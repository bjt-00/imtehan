/**
 * 
 */
package com.bitguiders.imtehan.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitguiders.imtehan.dataaccess.orm.QuestionBundleORM;
import com.bitguiders.imtehan.model.QuestionBundle;

/**
 * @author yared
 *
 */

@Repository
public class InMemoryQuestionBundleRepository implements QuestionBundleRepository {

	
	@Autowired 	
	private QuestionRepository questionRepo;
	
	private List<QuestionBundleORM> questionBundleList;
	
	public InMemoryQuestionBundleRepository(){
		
		questionBundleList = new ArrayList<QuestionBundleORM>();
		
		QuestionBundle qb1 = new QuestionBundle();
		QuestionBundleORM orm = new QuestionBundleORM();
		QuestionBundleORM orm2 = new QuestionBundleORM();
		
		orm.setQuestionBundleId(1);
		//orm.setTechnology("JavaEE");
		orm.setTitle("WAA FE");
		orm.setType("Exam");
		//qb1.setQuestionsInBundle(this.questionRepo.getAllQuestion());
		
		orm2.setQuestionBundleId(2);
		//qb2.setTechnology("SpringMVC");	
		orm2.setTitle("Interview with Google");
		orm2.setType("Interview");
		//qb2.setQuestionsInBundle(this.questionRepo.getAllQuestion());
		
		questionBundleList.add(orm);
		questionBundleList.add(orm2);
		
		
	}
	
	@Override
	public List<QuestionBundleORM> getAllQuestionBundles() {				
		return this.questionBundleList;
	}

	@Override
	public QuestionBundleORM getQuestionBundle(int questionBundleId) {
		
		for(QuestionBundleORM qb : questionBundleList)
		{
			if(qb.getQuestionBundleId()== questionBundleId){
				return qb;
			}
		}
		
		System.out.println("No matching question bundle id with and id of :  " + questionBundleId);
		return null;
	}

	
}
