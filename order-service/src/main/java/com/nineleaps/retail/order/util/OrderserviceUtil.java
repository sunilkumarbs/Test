package com.nineleaps.retail.order.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nineleaps.retail.order.dto.ResponseStatusEntity;

public interface OrderserviceUtil {
	public static ResponseEntity<Object> buildResponse(HttpStatus httpStatus, String message) {
		ResponseStatusEntity responseStatus = new ResponseStatusEntity(httpStatus.value(), httpStatus.getReasonPhrase(),
				message);
		return new ResponseEntity<Object>(responseStatus, httpStatus);
	}
}
