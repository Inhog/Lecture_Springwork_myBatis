package com.clustering.project.service;

import java.util.List;

import com.clustering.project.dao.CommonCodeDao;

public class OrganizationService {
	
	private CommonCodeDao dao;
	
	public String asdf = "aa";
	public OrganizationService() {}
	
	public OrganizationService(CommonCodeDao commonCodeDao) {
		this.dao = commonCodeDao;
	}
	
	public OrganizationService(CommonCodeDao commonCodeDao, String Asdf) {
		this.dao = commonCodeDao;
		this.asdf = Asdf;
	}
	
	
}
