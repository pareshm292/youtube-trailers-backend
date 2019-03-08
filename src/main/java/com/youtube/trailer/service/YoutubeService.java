package com.youtube.trailer.service;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.youtube.trailer.model.Result;
import com.youtube.trailer.model.YoutubeResponseWrapper;

@Service
public class YoutubeService {

	@Autowired
	private YouTubeProperties properties;
	
	@Autowired
	private RestTemplate template;
	
	public String getVideoUrl(String movieName) {
		
		String URL = "https://www.googleapis.com/youtube/v3/"
				+ "search?q="
				+ movieName.replace(" ", "+")  
				+ "+trailer"
				+ "&type=video&videoDefinition=any"
				+ "&pageToken="
				+ "&maxResults=1"
				+ "&key=" +
				properties.getKey() +
				"&part=snippet&relevanceLanguage=en";
		
		System.out.println(URL);
		
		YoutubeResponseWrapper wrapper = template.getForObject(URL, YoutubeResponseWrapper.class);  
		
		return wrapper.getItems().get(0).getVideoId();
	}
	
	@Component
	@ConfigurationProperties(prefix = "youtube")
	public static class YouTubeProperties {

		@NotEmpty 
		private String key;
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		
	}
}
