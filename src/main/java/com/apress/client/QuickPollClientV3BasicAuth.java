package com.apress.client;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class QuickPollClientV3BasicAuth {

	private static final String QUICK_POLL_URI_V3 = "http://localhost:8888/v3/polls";
	private RestTemplate restTemplate = new RestTemplate();
	
	private HttpHeaders getAuthenticationHeader(String username, String password){
		String credentials = username + ":" + password;
		byte[] base64CredentialData = Base64.encodeBase64(credentials.getBytes());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic "+ new String(base64CredentialData));
		return headers;
	}
	public void deletePoll(Long pollId){
		HttpHeaders authenticationHeaders = getAuthenticationHeader("admin", "admin");
		restTemplate.exchange(QUICK_POLL_URI_V3 + "/{pollId}", HttpMethod.DELETE, new HttpEntity<Void>(authenticationHeaders),Void.class, pollId);
	}
}
