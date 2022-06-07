package com.ITOITTracker.ITTracker.JPARepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITOITTracker.ITTracker.Entity.User;

public interface UsersRepository extends JpaRepository<User, Integer>{

}
