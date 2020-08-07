package com.frontendauthentication.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
class ApiError {
   private Boolean success;
   private HttpStatus status;
   private String message;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
   private LocalDateTime timestamp;
   private long nanoTime;
   private String debugMessage;

   private ApiError() {
	   success = false;
       timestamp = LocalDateTime.now();
       nanoTime = System.nanoTime();
   }

   ApiError(HttpStatus status) {
       this();
       this.status = status;
   }
   ApiError(HttpStatus status, String message) {
       this();
       this.status = status;
       this.message = message;
   }


   ApiError(HttpStatus status, String message, Throwable ex) {
       this();
       this.status = status;
       this.message = message;
       this.debugMessage = ex.getLocalizedMessage();
   }
   


}