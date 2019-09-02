package com.segware.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.segware.bean.Posted;

public interface PostedRepository extends MongoRepository<Posted, String> {
	
	Posted findFirstByDescription(String description);
	
    @Query("{description:'?0'}")
    List<Posted> findCustomByDescription(String description);

    @Query("{description : { $regex: ?0 } }")
    List<Posted> findCustomByRegExDescription(String description);

}
