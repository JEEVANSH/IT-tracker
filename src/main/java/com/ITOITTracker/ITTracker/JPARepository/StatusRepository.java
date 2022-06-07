package com.ITOITTracker.ITTracker.JPARepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITOITTracker.ITTracker.Entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
