package com.ex.tiggle.reserve.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.reserve.model.dao.ReserveDao;

@Service("reserveService")
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	private ReserveDao reserveDao;
}// ReserveService end
