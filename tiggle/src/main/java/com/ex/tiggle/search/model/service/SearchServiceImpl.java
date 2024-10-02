package com.ex.tiggle.search.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.search.model.dao.SearchDao;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchDao searchDao;
}// SearchService end
