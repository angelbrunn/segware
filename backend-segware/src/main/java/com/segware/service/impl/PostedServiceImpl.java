package com.segware.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segware.bean.Posted;
import com.segware.bean.Posteds;
import com.segware.repository.CustomRepository;
import com.segware.repository.PostedRepository;
import com.segware.service.PostedService;

@Service
public class PostedServiceImpl implements PostedService {

	@Autowired
	PostedRepository repository;

	@Autowired
	CustomRepository CustomRepo;

	private static Posteds listPosted;

	public static final Logger logger = LoggerFactory.getLogger(PostedServiceImpl.class);

	// get all
	public Posteds getAllPosteds() {
		listPosted = new Posteds();
		try {
			repository.findAll().forEach(
					u -> listPosted.getPostedList().add(new Posted(u.getId(), u.getDescription(), u.getVotes())));
			logger.info("Get All posted records...");
		} catch (Exception e) {
			logger.info("Error Get All Posteds: " + e.toString());
		}
		return listPosted;
	}

	// save
	public boolean addPosted(Posted posted) {
		try {
			repository.save(posted);
			logger.info("Save posted records...");
			return true;
		} catch (Exception e) {
			logger.info("Error with Save Posted: " + e.toString());
			return false;
		}
	}

	// delete AllPosted
	public boolean deleteAllPosted() {
		try {
			repository.deleteAll();
			logger.info("Deleting all posted records...");
			return true;
		} catch (Exception e) {
			logger.info("Error with DeleteAll Posted: " + e.toString());
			return false;
		}
	}

	// delete one Posted
	public boolean deleteOnePosted(Integer postedId) {
		try {
			repository.deleteById(postedId.toString());
			logger.info("Deleting one posted ...");
			return true;
		} catch (Exception e) {
			logger.info("Error with Delete one Posted: " + e.toString());
			return false;
		}
	}

	// update with Custom Template Spring
	public boolean updateCustomPosted(Posted posted) {
		try {
			CustomRepo.updatePosted(posted);
			logger.info("Adding posted data with custom template...");
			return true;
		} catch (Exception e) {
			logger.info("Error Adding one Posted with custom template: " + e.toString());
			return false;
		}
	}

	// update
	public boolean updatePosted(Posted posted) {
		try {
			repository.save(posted);
			logger.info("Adding posted data...");
			return true;
		} catch (Exception e) {
			logger.info("Error Adding one Posted: " + e.toString());
			return false;
		}
	}

	// find by descriptor
	public void findFirstByDescription(String descriptor) {
		try {
			logger.info("Finding first posted by desciption");
			Posted u = repository.findFirstByDescription(descriptor);
			logger.info("" + u);
		} catch (Exception e) {
			logger.info("Error in Finding first posted by desciption - ", e.toString());
		}
	}

	// find by descriptor with regex
	public void findByRegex(String descripContent) {
		try {
			logger.info("Finding by Regex - All with posted starting with <descripContent>");
			repository.findCustomByRegExDescription(descripContent).forEach(u -> System.out.println(u));
		} catch (Exception e) {
			logger.info("Error in Finding by Regex - ", e.toString());
		}
	}

}
