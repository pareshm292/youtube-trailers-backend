package com.youtube.trailer.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YoutubeResult {

	
	private String videoId;

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	@JsonProperty("id")
	private void unpackedVideoId(Map<String,String> id) {
		videoId = id.get("videoId");
	}
	
	@Override
	public String toString() {
		return String.format("YoutubeResult [videoId=%s]", videoId);
	}
	
	
	
	
	
}
