package com.frontendauthentication.exception;

public class ServiceUnavailableException extends RuntimeException{
	private static final long serialVersionUID = 8956220829979476801L;
	private String serviceName ;
	private String causeMessage ;

	public ServiceUnavailableException() {
        super();
	}
	public ServiceUnavailableException(String message) {
        super(message);
	}
	public ServiceUnavailableException(String message, String serviceName) {
        super(message);
        this.serviceName = serviceName;
	}
	public ServiceUnavailableException(String message, String serviceName, String causeMessage) {
        super(message);
        this.serviceName = serviceName;
        this.setCauseMessage(causeMessage);
	}
	

	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getCauseMessage() {
		return causeMessage;
	}
	public void setCauseMessage(String causeMessage) {
		this.causeMessage = causeMessage;
	}
	
	public String getDebugMessage() {
		return this.getMessage() + " , service: " + serviceName + ", cause: "+ causeMessage; 
	}
	
	
}
