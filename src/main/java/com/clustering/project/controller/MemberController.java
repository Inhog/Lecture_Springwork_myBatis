/**
 * It's Designed For incubation Center
 * @author ohsanghun
 * @version     %I%, %G%
 * @since       1.0
 */
package com.clustering.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clustering.project.component.MapParamCollector;
import com.clustering.project.service.MemberService;

@Controller
public class MemberController {
	private final static String MAPPING = "/member/";
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = MAPPING+"{action}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView actionMethod(MapParamCollector paramMethodMap, @PathVariable String action,
			ModelAndView modelandView) {
		Map<Object,Object> paramMap = paramMethodMap.getMap();
		Map<String, Object> resultMap = new HashMap<String, Object>() ;
		List<Object> resultList = new ArrayList<Object>();
		
		
		String viewName = MAPPING + action ;
		String forwardView = (String) paramMap.get("forwardView") ;
		
		
		// divided depending on action value
		if ("edit".equalsIgnoreCase(action)) {
		} else if ("update".equalsIgnoreCase(action)) {
			resultMap = (Map<String, Object>) service.getObject(paramMap);
			paramMap.put("action", action);
		} else if ("merge".equalsIgnoreCase(action)) {
			resultMap = (Map<String, Object>) service.saveObject(paramMap);
		} else if ("read".equalsIgnoreCase(action)) {
			resultMap = (Map<String, Object>) service.getObject(paramMap);
		} else if ("list".equalsIgnoreCase(action)) {
			resultList = (List<Object>) service.getList(paramMap);
		} else if ("delete".equalsIgnoreCase(action)) {
			resultList = (List<Object>) service.deleteObject(paramMap);
			viewName = "/member/list";
		} else if ("list_pagination".equalsIgnoreCase(action)) {
			resultMap = (Map<String,Object>) service.getListPagination(paramMap);
		}
		
		if(forwardView != null){
			viewName = forwardView;
		}
		
		modelandView.setViewName(viewName);

		modelandView.addObject("paramMap", paramMap);
		modelandView.addObject("resultMap", resultMap);
		modelandView.addObject("resultList", resultList);
		return modelandView;
	}
}