package com.ITOITTracker.ITTracker.ServiceConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.Entity.Admin;
import com.ITOITTracker.ITTracker.Entity.Ticket;
import com.ITOITTracker.ITTracker.Entity.User;
import com.ITOITTracker.ITTracker.JPARepository.TicketRepository;
import com.ITOITTracker.ITTracker.Response.TicketResponse;
import com.ITOITTracker.ITTracker.Services.AdminServices;
import com.ITOITTracker.ITTracker.Services.CategoryServices;
import com.ITOITTracker.ITTracker.Services.PriorityServices;
import com.ITOITTracker.ITTracker.Services.StatusServices;
import com.ITOITTracker.ITTracker.Services.SubCategoryServices;
import com.ITOITTracker.ITTracker.Services.TicketServices;
import com.ITOITTracker.ITTracker.Services.UserServices;

@Service
public class TicketServicesImpl implements TicketServices{
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private AdminServices adminService;
	@Autowired
	private UserServices userService;
	@Autowired
	private StatusServices statusService;
	@Autowired
	private CategoryServices categoryService;
	@Autowired
	private SubCategoryServices subCategoryService;
	@Autowired
	private PriorityServices priorityService;
	@Override
	public List<Ticket> getAllTickets() {
	List<Ticket> ticketList = new ArrayList<Ticket>();
	ticketList = ticketRepository.findAll();
	return ticketList;
	}
	@Override
	public String createTicket(Ticket ticket, int userid) {
		int category = 0;
		int subCategory = 0;
		int priority = 0;
	if (userService.getUser(userid) == null)
	return "Invalid User Id";
	User user = userService.getUser(userid);
	category = categoryService.getType(ticket.getCategory_id());
	subCategory = subCategoryService.getDescription((ticket.getSubCategory_id()),(ticket.getCategory_id()));
	priority = priorityService.getType(ticket.getPriority_id());
	if(category==0)
	return "Invalid Category Id \n1)Hardware\n2)Software\n3)Access Management";
	if(subCategory == 0)
	return "Invalid Sub Category Id";
	if(priority == 0)
	return "Invalid Priority Id";
	ticket.setCategory_id(category);
	ticket.setSubCategory_id(subCategory);
	ticket.setPriority_id(priority);
	ticket.setStatus_id(statusService.getType(1));
	ticket.setReport_id(userid);
	ticket.setUser(user);
	LocalDateTime now = LocalDateTime.now();
	ticket.setCreate_datetime(getTimeNow(now));
	ticket.setLast_modified_datetime(getTimeNow(now));
	ticketRepository.save(ticket);
	return "Ticket Created Successfully Created \n" + "http://localhost:8080/api/tickets/"+ ticket.getTicket_id();			
	}
	@Override
	public Ticket getTicket(int ticketid) {
	Ticket ticket  = ticketRepository.findById(ticketid).get();
	return ticket;
	}
	@Override
	public List<Ticket> getTickets(int userid) {
	List<Ticket> list = new ArrayList<Ticket>();
	list = ticketRepository.findAll().stream().filter(t -> t.getReport_id() == userid).collect(Collectors.toList());
	return list;
	}
	@Override
	public String setAssignee(int ticketid, int id, Admin admin) {
	Ticket ticket = null;
	Admin admins = null;
	try {
	ticket =  getTicket(ticketid);
	if (ticket == null)
	return "Ticket Id Not Found";
	if (adminService.getAdmin(id) == null)
	return "Admin Id Not Found";
	admin = adminService.getAdmin(admin.getId());
	ticket.setAssignee(admins);
	LocalDateTime now = LocalDateTime.now();
	ticket.setLast_modified_datetime(getTimeNow(now));
	ticketRepository.save(ticket);
	} catch (Exception e) {
	}
	String	response = "Assignee set Successfully";
	return response;
	}
	@Override
	public String changeStatus(int ticketid, int user_id, int status_id) {
	Ticket ticket = null;
	User user = null;
	String old = null;
	String present = null;
	try {
	ticket = getTicket(ticketid);
	if (ticket == null)
	return "Invalid Ticket id";
	old = ticket.getStatus_id();
	user = userService.getUser(user_id);
	if (user == null)
	return "Invalid User ID";
	String status = statusService.getType(status_id);
	if (status == null)
	return "Invalid Status Id";
	ticket.setStatus_id(statusService.getType(status_id));
	LocalDateTime now = LocalDateTime.now();
	ticket.setLast_modified_datetime(getTimeNow(now));
	ticketRepository.save(ticket);
	present = ticket.getStatus_id();
	} catch (Exception e) {
	}
	return "Status Change from " + old + " to " + present;
	}
	private String getTimeNow(LocalDateTime now) {
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
	String formatDateTime = now.format(format);
	return formatDateTime;
	}
	@Override
	public Ticket updateTicket(Ticket ticket) {
	LocalDateTime now = LocalDateTime.now();
	ticket.setLast_modified_datetime(getTimeNow(now));
	return ticketRepository.save(ticket);
	}
	@Override
	public List<TicketResponse> getList(List<Ticket> ticketList) {
	List<TicketResponse> list = new ArrayList<TicketResponse>();
	for (Ticket t : ticketList) {
	list.add(new TicketResponse(t));
	}
	return list;
	}
}
