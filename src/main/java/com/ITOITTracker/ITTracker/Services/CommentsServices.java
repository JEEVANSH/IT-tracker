package com.ITOITTracker.ITTracker.Services;

import com.ITOITTracker.ITTracker.Entity.Comments;

public interface CommentsServices {
	public String addAdminComment(int ticketid, int userid, Comments comment);
	public String addUserComment(int ticketid, int userid, Comments comment);

}
