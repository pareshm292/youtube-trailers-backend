package com.youtube.trailer.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YoutubeResponseWrapper {

	@JsonProperty("items")
	private List<YoutubeResult> items = new ArrayList<>();

	public List<YoutubeResult> getItems() {
		System.out.println(items);
		return items;
	}

	public void setItems(List<YoutubeResult> items) {
		this.items = items;
	}
	
	
}
