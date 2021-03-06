package com.bitguiders.imtehan.service.rest.client;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

abstract class RestClientSupport<E> {
	
	public RestTemplate restTemplate = new RestTemplate();
	public Gson gson = new GsonBuilder().create();
	public REST service;
	
	public enum REST{
		
		QUESTION_UNDLE("qb"),
		QUESTION("q");
		//private String host="http://localhost/bitguiders/rest/ttts/?s";
		private String host="http://bitguiders.com/rest/ttts/?s=";
		private String service;
		
		 REST(String service){
			this.service = service;
		}
		public String getListURL(){
			return host+service+"&a=list";
		}
		public String getListURL(int id){
			return host+service+"&a=list&id="+id;
		}
		public String getSelectURL(int id){
			return host+service+"&a=select&id="+id;
		}
		public String getDeleteURL(int id){
			return host+service+"&a=delete&id="+id;
		}
		@Deprecated
		public String getAddURL(String data){
			return host+service+"&a=add&data="+data;
		}
		public String getAddURL(){
			return host+service+"&a=add";
		}
		@Deprecated
		public String getUpdateURL(int id,String data){
			return host+service+"&a=update&id="+id+"&data="+data;
		}
		@Deprecated
		public String getUpdateURL(int id){
			return host+service+"&id="+id;
		}
		public String getUpdateURL(){
			return host+service;
		}
		public String getURL(){
			return host+service;
		}

	}
	RestClientSupport(REST service){
		this.service = service;
	}
	public String getJson(String url){
		return restTemplate.getForObject(url, String.class);
	}
	@Deprecated
	public String delete(int id) {
		return getJson(service.getDeleteURL(id));
	}

}
