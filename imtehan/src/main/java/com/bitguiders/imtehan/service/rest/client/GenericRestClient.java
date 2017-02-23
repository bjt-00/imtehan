package com.bitguiders.imtehan.service.rest.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

 interface GenericRestClient<E> {
	public List<E> getList();
	public E getById(int id);
	public String add(E e);
	public String update(E e,HttpServletRequest request);
	public String delete(int id);
	String toUpdate(E qb);
	String toSQL(E qb);
}
