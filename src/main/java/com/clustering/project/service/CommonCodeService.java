package com.clustering.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.project.dao.ShareDao;
import com.clustering.project.util.CommonUtil;

@Service
public class CommonCodeService {

	@Autowired
	private ShareDao dao;
	
	@Autowired
	private CommonUtil commonUtil;
	
	public Object getList(Object dataMap) {
		String sqlMapId = "commonCode.list";
		
		Object resultObject = dao.getList(sqlMapId, dataMap);

		return resultObject;
	}

	public Object getObject(Object dataMap) {
		String sqlMapId = "commonCode.read";
		
		Object resultObject = dao.getObject(sqlMapId, dataMap);
		
		return resultObject;
	}

	public Object saveObject(Map<Object, Object> paramMap) {
		String uniqueSequence = (String) paramMap.get("COMMONCODE_ID");
		
		if("".equals(uniqueSequence)){
			uniqueSequence = commonUtil.getUniqueSequence();
		}
		paramMap.put("COMMONCODE_ID", uniqueSequence);
		paramMap.put("REGISTER_SEQ", "UUID-1111-1111111");
		paramMap.put("MODIFIER_SEQ", "UUID-1111-1111111");
		
		String sqlMapId = "commonCode.merge";
		Integer resultKey = (Integer) dao.saveObject(sqlMapId, paramMap);
		
		sqlMapId = "commonCode.read";
		Object resultObject = dao.getObject(sqlMapId, paramMap);

		return resultObject;
	}

	public Object deleteObject(Object dataMap) {
		
		
//		String sqlMapId = "commonCode.parent_delete";
		
		String sqlMapId = "commonCode.delete";

		Integer resultKey = (Integer) dao.deleteObject(sqlMapId, dataMap);

		sqlMapId = "commonCode.list";
		
		Object resultObject = dao.getList(sqlMapId, null);
		
		return resultObject;
	}
	
}
