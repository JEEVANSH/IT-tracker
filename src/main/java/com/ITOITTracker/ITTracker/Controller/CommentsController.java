package com.ITOITTracker.ITTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITOITTracker.ITTracker.Entity.Comments;
import com.ITOITTracker.ITTracker.Services.CommentsServices;

@RestController
@RequestMapping("/api")
public class CommentsController {
	@Autowired
	private CommentsServices commentService;
	@PostMapping("/comments/admin")
	public ResponseEntity<?> addAdminComment(@RequestParam(value =  "ticketid") int ticketid, @RequestParam(value =  "adminid") int adminid,@RequestBody Comments comment) {
	String response = commentService.addAdminComment(ticketid, adminid, comment);
	return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PostMapping("/comments/user")
	public ResponseEntity<?> addUserComment(@RequestParam("ticketid") int ticketid, @RequestParam("userid") int userid,@RequestBody Comments comment) {
	String response = commentService.addUserComment(ticketid, userid, comment);
	return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
