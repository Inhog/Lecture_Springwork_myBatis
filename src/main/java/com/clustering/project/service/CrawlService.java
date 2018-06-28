package com.clustering.project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.project.dao.ShareDao;

@Service
public class CrawlService {
	
	@Autowired
	private ShareDao dao;
	
	public Object getListMIT(Object dataMap) {
		List<Object> resultObject = new ArrayList<Object>();
		Document doc;
		try {
			doc = Jsoup.connect("http://www.mit.edu/").get();
			Elements questions = doc.select("a[href]");
			for(Element link: questions) {
				if(link.attr("href").contains("mit.edu"))
					resultObject.add(link.attr("abs:href"));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return resultObject;
	}
}
