package com.service.impl;

import java.util.List;

import com.bean.Checi;
import com.dao.CheciDao;
import com.service.CheciService;

public class CheciServiceImpl implements CheciService{
	private CheciDao dao;
	
	public void setDao(CheciDao dao) {
		this.dao = dao;
	}

	public List<Checi> getAllCheci() {
		return dao.selectAllCheci();
	}
	
}
