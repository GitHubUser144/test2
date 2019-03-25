package com.dao;

import java.util.List;

import com.bean.Checi;

public interface CheciDao {
	/**
	 * 查询所有车次
	 * @return
	 */
	public List<Checi> selectAllCheci();
}
