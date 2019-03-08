package com.youtube.trailer.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OMDbResponseWrapper {

	@JsonProperty("Search")
	private List<Result> omdbResults = new ArrayList<>();

	public List<Result> getOmdbResults() {
		return omdbResults;
	}

	public void setOmdbResults(List<Result> omdbResults) {
		this.omdbResults = omdbResults;
	}
	
	
	
}
