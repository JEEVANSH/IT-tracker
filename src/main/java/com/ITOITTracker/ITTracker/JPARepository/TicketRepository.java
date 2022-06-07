package com.ITOITTracker.ITTracker.JPARepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITOITTracker.ITTracker.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
