package com.ITOITTracker.ITTracker.ServiceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.JPARepository.SubCategoryRepository;
import com.ITOITTracker.ITTracker.Services.SubCategoryServices;

@Service
public class SubCategoryServicesImpl implements SubCategoryServices {
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Override
	public int getDescription(int s_id, int c_id) {
	int msg = 0;
	if (subCategoryRepository.findById(s_id).get().getCategory().getCategory_id() == c_id)
	msg = subCategoryRepository.findById(s_id).get().getSubCategory_id();
	return msg;
	}
	@Override
	public boolean isPresent(int s_id, int c_id) {
	return false;
	}
}
