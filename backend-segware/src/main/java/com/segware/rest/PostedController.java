package com.segware.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.segware.bean.Posted;
import com.segware.bean.Posteds;
import com.segware.exception.SegwareExceptionHandler;
import com.segware.service.PostedService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(path = "/posteds")
public class PostedController {
	
	@Autowired
	PostedService postedService;
	
	public static final Logger logger = LoggerFactory.getLogger(PostedController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity <Posteds> listPosted() {
		try {
			 return ResponseEntity.ok(postedService.getAllPosteds());
		} catch (SegwareExceptionHandler e) {
			 logger.error(e.getMessage());
			 return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);			 
		}		
	}

	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Posted posted) throws SegwareExceptionHandler {
		postedService.addPosted(posted);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void update(@RequestBody Posted posted) throws SegwareExceptionHandler {
		postedService.updatePosted(posted);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateById(@PathVariable("id") Long id, @RequestBody Posted posted)  throws SegwareExceptionHandler {
		// Todo . . first find by Id then update this!
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePosted(@PathVariable Integer id) throws SegwareExceptionHandler {
		postedService.deleteOnePosted(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteAllPosted() throws SegwareExceptionHandler {
		postedService.deleteAllPosted();
	}

}
