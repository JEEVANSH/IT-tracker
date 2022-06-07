package com.ITOITTracker.ITTracker.JPARepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITOITTracker.ITTracker.Entity.Category;

public interface CategoryRepository	extends JpaRepository<Category, Integer> {

}
