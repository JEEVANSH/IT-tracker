package com.ITOITTracker.ITTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITOITTracker.ITTracker.Entity.Admin;
import com.ITOITTracker.ITTracker.Entity.Ticket;
import com.ITOITTracker.ITTracker.Response.Response;
import com.ITOITTracker.ITTracker.Services.TicketServices;

@RestController
@RequestMapping("/api")
public class TicketController {
	@Autowired
	private TicketServices ticketServices;
	@GetMapping("/tickets")
	public ResponseEntity<?> getAllTickets() {
	if(ticketServices.getAllTickets().isEmpty())
	return new ResponseEntity<>(new Response("No Data Found"), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(ticketServices.getAllTickets(), HttpStatus.FOUND);
	}
	@PostMapping("/tickets")
	public ResponseEntity<?> createTicket(@RequestBody Ticket ticket, @RequestParam("userid") int userid) {
	String response = ticketServices.createTicket(ticket, userid);
	return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@GetMapping("/tickets/")
	public ResponseEntity<?> getTickets(@RequestParam("userid") int userid) {
	List<Ticket> list = ticketServices.getTickets(userid);
	if (list.isEmpty())
	return new ResponseEntity<>(new Response("No Data Found"), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(ticketServices.getList(list), HttpStatus.CREATED);
	}
	@GetMapping("/tickets/{ticketid}")
	public ResponseEntity<?> getTicket(@PathVariable("ticketid") int ticketid){
	Ticket t = ticketServices.getTicket(ticketid);
	if (t == null)
	return new ResponseEntity<>(new Response("No Data Found"), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(t, HttpStatus.CREATED);
	}
	@PutMapping("/tickets/{ticketid}/")
	public ResponseEntity<?> setAssignee(@PathVariable("ticketid") int ticketid, @RequestParam("adminid") int adminid,@RequestBody Admin admin) {
	String response = ticketServices.setAssignee(ticketid, adminid, admin);
	if (response.equals("Ticket Id Not Found") || response.equals("Admin Id Not Found"))
	return new ResponseEntity<>(new Response(response), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PutMapping("/tickets/")
	public ResponseEntity<?> changeStatus(@RequestParam("ticketid") int ticketid, @RequestParam("adminid") int adminid,@RequestParam("statusid") int statusid) {
	String reponse = ticketServices.changeStatus(ticketid, adminid, statusid);
	if (reponse == null)
	return new ResponseEntity<>(new Response("Invalid Ticket Id or Admin Id"), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(reponse, HttpStatus.CREATED);
	}

	
}
