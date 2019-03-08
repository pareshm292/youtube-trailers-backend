package com.youtube.trailer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("Title")
	private String title;
	
	private String videoId="";
	
	public Result(String title, String videoId) {
		super();
		this.title = title;
		this.videoId = videoId;
	}
	
	public Result() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	@Override
	public String toString() {
		return String.format("Result [title=%s, videoId=%s]", title, videoId);
	}
	
}
