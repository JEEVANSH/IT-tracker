package com.ITOITTracker.ITTracker.ServiceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.JPARepository.StatusRepository;
import com.ITOITTracker.ITTracker.Services.StatusServices;

@Service
public class StatusServiceImpl implements StatusServices {
	@Autowired
	private StatusRepository statusRepository;
	@Override
	public String getType(int id) {
	String msg= statusRepository.findById(id).get().getStatus_msg();
	return msg;
	}
	@Override
	public boolean isPresent(int id) {
	return false;
	}
}
