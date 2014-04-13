package com.portal.service;


import com.portal.vo.KindLevel;


public interface KindLevelService {
	
	void save(KindLevel kindLevel)throws Exception;
	KindLevel loadById(int id);
}
