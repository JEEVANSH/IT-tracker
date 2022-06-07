package com.ITOITTracker.ITTracker.JPARepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITOITTracker.ITTracker.Entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{

}
