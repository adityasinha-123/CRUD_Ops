package com.atmecs.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * returns a resourceName,fieldName,fieldValue that does not exist in DB to the client
 * a constructor will be generated for these fields 
 * a message(source not found for the fields) will be passed to the superclass constructor
 * String.format is used to format the string
 * %s is used to dynamically pass the field values
 * getter method is used to get the fields name
 * @ResponseStatus is used here so no need to mention it after every REST API
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
		
	}
	
	public Object getFieldValue() {
		return fieldValue;
		
	}
	
	

}
