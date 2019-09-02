package com.segware.service;

import org.springframework.stereotype.Service;

import com.segware.bean.Posted;
import com.segware.bean.Posteds;

@Service
public interface PostedService {

	Posteds getAllPosteds();

	boolean addPosted(Posted posted);

	boolean deleteAllPosted();

	boolean deleteOnePosted(Integer postedId);

	boolean updateCustomPosted(Posted posted);

	boolean updatePosted(Posted posted);

	void findFirstByDescription(String descriptor);

	void findByRegex(String descripContent);

}
