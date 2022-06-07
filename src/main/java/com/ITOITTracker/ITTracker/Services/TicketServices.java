package com.ITOITTracker.ITTracker.Services;

import java.util.List;

import com.ITOITTracker.ITTracker.Entity.Admin;
import com.ITOITTracker.ITTracker.Entity.Ticket;
import com.ITOITTracker.ITTracker.Response.TicketResponse;

public interface TicketServices {
	
	public List<Ticket> getAllTickets();
	public String createTicket(Ticket ticket, int userid);
	public Ticket getTicket(int ticketid);
	public List<Ticket> getTickets(int userid);
	public String setAssignee(int ticketid, int adminid, Admin admin);
	public String changeStatus(int ticketid, int adminid, int status_id);
	public Ticket updateTicket(Ticket ticket);
	public List<TicketResponse> getList(List<Ticket> list);
}
