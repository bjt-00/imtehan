package com.bitguiders.imtehan.service.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	RestTemplate restTemplate = new RestTemplate();
	String url="http://bitguiders.com/rest/ttts/?s=qb";
//	String url="http://localhost:8080/imtehan/qb";

	public  void post(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("id", 45+"");
       // map.add("data", toUpdate(qb));
        map.add("a","update");

		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, req, String.class);
		System.out.println(response.getBody());
	}
	public void get(){
		System.out.println(restTemplate.getForObject( url+"/updatett.do", String.class));
	}
	public static void main(String[] args) {
		RestClient c = new RestClient();
		//c.get();
		c.post();

	}

}
