package com.segware.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import com.segware.bean.Posted;

@Component
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public long updatePosted(Posted posted) {

		Query query = new Query(Criteria.where("id").is(posted.getId()));
		Update update = new Update();
		update.set("posted", posted);

		UpdateResult result = mongoTemplate.updateFirst(query, update, Posted.class);

		if (result != null)
			return result.getModifiedCount();
		else
			return 0;
	}

}
