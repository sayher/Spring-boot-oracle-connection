package com.frontendauthentication.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ResponseMessageModel {
	private Boolean success;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
	private String message;
	private Object data;

	private ResponseMessageModel() {
	   timestamp = LocalDateTime.now();
   }

	public ResponseMessageModel(Boolean success, String message, Object data) {
		this();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	

}
