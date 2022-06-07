package com.ITOITTracker.ITTracker.Response;

import java.io.Serializable;

public class Response implements Serializable {
	String message;
	public Response(String message) {
	super();
	this.message = message;
	}
	public String getMessage() {
	return message;
	}
}
