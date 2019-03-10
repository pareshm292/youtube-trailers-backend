package com.youtube.trailer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.trailer.model.Result;
import com.youtube.trailer.service.OMDbService;

@CrossOrigin("https://heroku.com")
@RestController
public class TrailerController {

	@Autowired
	private OMDbService omdbService;
	
	@RequestMapping(value = "/search/{term}", method = RequestMethod.GET)
	public List<Result> search(@PathVariable String term) {
		return omdbService.search(term);
	}
	
}
