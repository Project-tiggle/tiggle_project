package com.ex.tiggle.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.main.dao.MainDao;

@Service("mainService")
public class MainServiceImpl implements MainService {
	@Autowired
	private	MainDao mainDao;
} // MainService end
