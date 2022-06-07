package com.ITOITTracker.ITTracker.ServiceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.JPARepository.CategoryRepository;
import com.ITOITTracker.ITTracker.Services.CategoryServices;

@Service
public class CategoryServiceImpl implements CategoryServices {
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public boolean isPresent(int categoryId) {
	boolean found = false;
	found = categoryRepository.findById(categoryId).isPresent();
	return found;
	}
	@Override
	public int getType(int categoryId) {
	int description = categoryRepository.findById(categoryId).get().getCategory_id();
	return description;
	}

}
