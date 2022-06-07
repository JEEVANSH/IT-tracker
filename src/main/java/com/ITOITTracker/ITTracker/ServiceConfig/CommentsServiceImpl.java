package com.ITOITTracker.ITTracker.ServiceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.Entity.Admin;
import com.ITOITTracker.ITTracker.Entity.Comments;
import com.ITOITTracker.ITTracker.Entity.Ticket;
import com.ITOITTracker.ITTracker.Entity.User;
import com.ITOITTracker.ITTracker.JPARepository.CommentsRepository;
import com.ITOITTracker.ITTracker.Services.AdminServices;
import com.ITOITTracker.ITTracker.Services.CommentsServices;
import com.ITOITTracker.ITTracker.Services.TicketServices;
import com.ITOITTracker.ITTracker.Services.UserServices;

@Service
public class CommentsServiceImpl implements CommentsServices{
	@Autowired
	private CommentsRepository commentRepository;
	@Autowired
	private AdminServices adminServices;
	@Autowired
	private UserServices userServices;
	@Autowired
	private TicketServices ticketServices;
	@Override
	public String addAdminComment(int ticketid, int adminid, Comments comment) {
	Admin admin = null;
	Ticket ticket = null;
	admin = adminServices.getAdmin(adminid);
	if (admin == null)
	return "Admin Id is Invalid";
	ticket = ticketServices.getTicket(ticketid);
	if (ticket == null)
	return "Ticket Id is Invalid ";
	comment.setComment_msg(admin.getName() + "=" + comment.getComment_msg());
	comment.setAdmin(admin);
	comment.setTicket(ticketServices.updateTicket(ticket));
	commentRepository.save(comment);
	return "Successfully Added Comment on " + ticket.getTicket_id();
	}
	@Override
	public String addUserComment(int ticketid, int userid, Comments comment){
	User user = null;
	Ticket ticket = null;
	user = userServices.getUser(userid);
	if (user == null)
	return "User Id is Invalid";
	ticket = ticketServices.getTicket(ticketid);
	if (ticket == null)
	return "Ticket Id is Invalid";
	comment.setComment_msg(comment.getComment_msg());
	comment.setTicket(ticketServices.updateTicket(ticket));
	comment.setUser(user);
	commentRepository.save(comment);
	return "Comment added Successfully on Ticket " + ticket.getTicket_id();
	}

}
