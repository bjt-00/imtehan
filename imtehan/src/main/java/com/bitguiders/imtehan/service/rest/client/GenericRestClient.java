package com.bitguiders.imtehan.service.rest.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

 public abstract class GenericRestClient<E> extends RestClientSupport<E> {
	
	GenericRestClient(RestClientSupport.REST service) {
		super(service);
	}
	public abstract List<E> getList();
	public abstract E getById(int id);
	public abstract String add(E e,HttpServletRequest request);
	public abstract String update(E e,HttpServletRequest request);
	public abstract String delete(E e,HttpServletRequest request);
	public abstract String toUpdate(E qb);
	public abstract String toSQL(E qb);
	
	public HttpEntity<MultiValueMap<String, String>> getFormattedRequest(String id,HttpServletRequest request){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("id", id);
        request.getParameterMap().forEach((k,v)->map.add(k, v[0]));
                
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		return req;
	}

}
