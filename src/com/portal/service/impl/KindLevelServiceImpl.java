package com.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.BaseDAO;
import com.portal.service.KindLevelService;
import com.portal.vo.KindLevel;


@Service("kindLevelService")
public class KindLevelServiceImpl implements KindLevelService {
	
	@Autowired
	private BaseDAO<KindLevel> baseDAO;
	
	
	public void save(KindLevel kindLevel) throws Exception {
		
		try{
			
			baseDAO.save(kindLevel);
		
		}catch(Exception e){
			
			throw new Exception(e);
		}
	}


	@Override
	public KindLevel loadById(int id) {
		// TODO Auto-generated method stub
		return baseDAO.load(KindLevel.class, id);
	}
	
	
}
