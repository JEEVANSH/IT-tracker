package com.ITOITTracker.ITTracker.ServiceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.JPARepository.PriorityRepository;
import com.ITOITTracker.ITTracker.Services.PriorityServices;

@Service
public class PriorityServicesImpl implements PriorityServices{
	@Autowired
	private PriorityRepository priorityRepository;
	@Override
	public boolean isPresent(int id) {	
	return false;
	}
	@Override
	public int getType(int id) {
	int msg = priorityRepository.findById(id).get().getPriority_id();
	return msg;
	}
}
