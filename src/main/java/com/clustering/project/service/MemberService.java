package com.clustering.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.project.dao.ShareDao;
import com.clustering.project.util.CommonUtil;

@Service
public class MemberService {

	@Autowired
	private ShareDao dao;
	
	@Autowired
	private CommonUtil commonUtil;

	public Object getList(Object dataMap) {
		String sqlMapId = "member.list";

		Object resultObject = dao.getList(sqlMapId, dataMap);
		
		return resultObject;
	}

	public Object getObject(Object dataMap) {
		String sqlMapId = "member.read";

		Object resultObject = dao.getObject(sqlMapId, dataMap);
		
		sqlMapId = "attachfile.read";
		((Map<Object, Object>) resultObject).put("attachFileList",dao.getList(sqlMapId, dataMap));
		
		return resultObject;
	}

	public Object saveObject(Map<Object, Object> paramMap) {
		String uniqueSequence = (String) paramMap.get("MEMBER_SEQ");
		
		if("".equals(uniqueSequence)){
			uniqueSequence = commonUtil.getUniqueSequence();
		}
		paramMap.put("MEMBER_SEQ", uniqueSequence);
		paramMap.put("REGISTER_SEQ", "UUID-1111-1111111");
		paramMap.put("MODIFIER_SEQ", "UUID-1111-1111111");
		String sqlMapId = "member.merge";

		Object resultKey = dao.saveObject(sqlMapId, paramMap);
		
		sqlMapId = "oracle_authorityRmember.insert";
		
		resultKey = dao.saveObject(sqlMapId, paramMap);
		List<Object> aaa = (List<Object>) paramMap.get("attachFileList");
		
		if(!(aaa.isEmpty())){
		sqlMapId = "attachfile.merge";
		
		resultKey = dao.saveObject(sqlMapId, paramMap);
		}
		
		sqlMapId = "member.read";
		
		Object resultObject = dao.getObject(sqlMapId, paramMap);

		return resultObject;
	}

	public Object deleteObject(Object dataMap) {
		// delete child record authority
		String sqlMapId = "oracle_authorityRmember.delete";

		Integer resultKey = (Integer) dao.deleteObject(sqlMapId, dataMap);

		// delete Mother record authority
		sqlMapId = "member.delete";

		resultKey = (Integer) dao.deleteObject(sqlMapId, dataMap);

		// get Member List
		sqlMapId = "member.list";
		
		Object resultObject = dao.getList(sqlMapId, dataMap);
		
		return resultObject;
	}
}
