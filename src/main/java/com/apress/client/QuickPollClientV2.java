package com.apress.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.apress.domain.Poll;

public class QuickPollClientV2 {

	private static final String QUICK_POLL_URI_V2 = "http://localhost:8888/v2/polls";
	private RestTemplate restTemplate = new RestTemplate();
	
	public PageWrapper<Poll> getAllPolls(int page, int size){
		ParameterizedTypeReference<PageWrapper<Poll>> responseType = 
				                      new ParameterizedTypeReference<PageWrapper<Poll>>(){};
		UriComponentsBuilder builder = UriComponentsBuilder
														.fromHttpUrl(QUICK_POLL_URI_V2)
														.queryParam("page", page)
														.queryParam("size", size);
		ResponseEntity<PageWrapper<Poll>> responseEntity = 
				restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null, responseType);
		return responseEntity.getBody();
	}
}
