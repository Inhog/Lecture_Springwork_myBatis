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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	private final static String MAPPING = "/member";
	
	@RequestMapping(value = MAPPING, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView) {

		String viewName = MAPPING + "/";
		String action = (String) paramMap.get("action") ;
		
		Map<String, Object> resultMap = new HashMap<String, Object>() ;
		List<Object> resultList = new ArrayList<Object>();

		// divided depending on action value
		if ("edit".equalsIgnoreCase(action)) {
			viewName = viewName + action;
		} else if ("read".equalsIgnoreCase(action)) {
			viewName = viewName + action;
			resultMap.put("MEMBER_ID", "293029301202");
			resultMap.put("NAME", "name 02");
			resultMap.put("PASSWORD", "hidden_password");
			resultMap.put("CELLPHONE", "001-3923-6940");		
			resultMap.put("EMAIL", "Hacker@bnt.com");		
			resultMap.put("MEMBER_SEQ", "103029301202-UUID");
			resultMap.put("COMMON_CODE_ID", "590293232849");
			resultMap.put("DESCRIPTION", "Yes or No. \nAnything writing.");
			resultMap.put("PARENT_COMMON_CODE_ID", "UUID-10482983293");
			resultMap.put("ORGANIZATION_SEQ", "UUID-10482983293");
			resultMap.put("TELEPHONE", "02-2930-3920");
			resultMap.put("ORDER_NUMBER", 2);
		} else if ("list".equalsIgnoreCase(action)) {
			viewName = viewName + action;
			
			Map<String, Object> data01 = new HashMap<String, Object>();
			Map<String, Object> data02 = new HashMap<String, Object>();
			Map<String, Object> data03 = new HashMap<String, Object>();
			
			data01.put("MEMBER_ID", "103029301202");
			data01.put("NAME", "name 01");
			data01.put("CELLPHONE", "001-2930-2938");		
			data01.put("EMAIL", "Anders@gmail.com");		
			data01.put("COMMON_CODE_ID", "490293232849");
			data01.put("DESCRIPTION", "anything DESCRIPTION 01");
			data01.put("ORGANIZATION_SEQ", "UUID-00482983293");
			data01.put("TELEPHONE", "031-2930-3920");
			data01.put("ORDER_NUMBER", 1);
			resultList.add(data01);

			data02.put("MEMBER_ID", "293029301202");
			data02.put("NAME", "name 02");
			data02.put("CELLPHONE", "001-3923-6940");		
			data02.put("EMAIL", "Hacker@bnt.com");		
			data02.put("COMMON_CODE_ID", "590293232849");
			data02.put("DESCRIPTION", "anything DESCRIPTION 02");
			data02.put("ORGANIZATION_SEQ", "UUID-10482983293");
			data02.put("TELEPHONE", "02-2930-3920");
			data02.put("ORDER_NUMBER", 2);
			resultList.add(data02);

			data03.put("MEMBER_ID", "323029301202");
			data03.put("NAME", "name 03");
			data03.put("CELLPHONE", "001-9503-1274");		
			data03.put("EMAIL", "polly@daddy.com");		
			data03.put("COMMON_CODE_ID", "690293232849");
			data03.put("DESCRIPTION", "anything DESCRIPTION 03");
			data03.put("ORGANIZATION_SEQ", "UUID-20482983293");
			data03.put("TELEPHONE", "042-2930-3920");
			data03.put("ORDER_NUMBER", 3);

			resultList.add(data03);
		} else {
			viewName = viewName + "list";
		} 

		modelandView.setViewName(viewName);

		modelandView.addObject("paramMap", paramMap);
		modelandView.addObject("resultMap", resultMap);
		modelandView.addObject("resultList", resultList);

		return modelandView;
	}
}