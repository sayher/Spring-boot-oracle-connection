package com.frontendauthentication.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
	@Value("${spring.application.name}")
	String appName;
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Invalid input format";	
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error));
	}

	
	@ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex, WebRequest request) {
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "Trasaction failed, " + ex.getMessage())); 
    }
	
    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<Object> handleServiceUnavailableException(ServiceUnavailableException ex, WebRequest request) {
    	return buildResponseEntity(new ApiError(HttpStatus.SERVICE_UNAVAILABLE, "Trasaction failed, " + (ex.getMessage()==null ? "Service Unavailable": ex.getMessage())), ex.getCauseMessage()); 
    }
    
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
    	
    	return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ex)); 
    }
	
//	@ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
//		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error", ex);
//		return buildResponseEntity(apiError); 
//    }
    
    
    private ResponseEntity<Object> buildResponseEntity(ApiError e, String... additionalMessages) {
    	
    	String additionalMessage = "";
    	if(additionalMessages.length > 0)
    		additionalMessage = ", " + additionalMessages[0];
    		
    	log.error(e.getMessage() + additionalMessage );
    	
		return new ResponseEntity<>(e, e.getStatus());
	}

}