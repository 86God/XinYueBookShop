package com.company.project.dao;

import com.company.project.model.po.LogPo;

public interface LogDao {
	boolean insert(LogPo logPo);
	
	boolean update(LogPo logPo);
	
	boolean delete(Long id);
	
	LogPo findById(Long id);
	
	LogPo[] findAll();
	
 }
