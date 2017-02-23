package com.bitguiders.imtehan.controller;

import org.springframework.ui.ModelMap;

public class GenericController {

	private static final String VIEW_ATTRIBUTE_NAME="view";
	private static final String VIEW_DASHBOARD="dashboard";
	private static final String VIEW_ATTRIBUTE_MSG="message";
	private ModelMap model;
	
	public void setMessage(String message,ModelMap model){
		model.addAttribute(VIEW_ATTRIBUTE_MSG,message);
	}
	public String getView(String view, ModelMap model){
		this.model=model;
		 model.addAttribute(VIEW_ATTRIBUTE_NAME,view);
		return VIEW_DASHBOARD;
	}
	public String getView(String view, ModelMap model,String message){
		this.model = model;
		setMessage(message,this.model);
		 model.addAttribute(VIEW_ATTRIBUTE_NAME,view);
		return VIEW_DASHBOARD;
	}

}
