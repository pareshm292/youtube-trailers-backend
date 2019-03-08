package com.youtube.trailer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.youtube.trailer.model.OMDbResponseWrapper;
import com.youtube.trailer.model.Result;

@Service
public class OMDbService {
	
	@Autowired
	private YoutubeService youtubeService;

	@Autowired
	private RestTemplate template;
	
	@Cacheable("results")
	public List<Result> search(String term) {					
		
		String URL = "http://www.omdbapi.com/?s=" + term + "&type=movie&apikey=" + "cc465c36" ;
		
		OMDbResponseWrapper wrapper = template.getForObject(URL, OMDbResponseWrapper.class);
		
		int resultSize = wrapper.getOmdbResults().size();
		if(resultSize >= 5 ) {
			wrapper.setOmdbResults(wrapper.getOmdbResults().subList(0, 4));
		}
		
		wrapper.getOmdbResults().
				forEach(result -> result.setVideoId(youtubeService.getVideoUrl(result.getTitle())));
		
		return wrapper.getOmdbResults();
	}

}
