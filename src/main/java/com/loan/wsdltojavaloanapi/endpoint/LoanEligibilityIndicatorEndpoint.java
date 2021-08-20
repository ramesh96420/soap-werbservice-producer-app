package com.loan.wsdltojavaloanapi.endpoint;

import org.example.spring.soap.api.loaneligibility.Acknowledgement;
import org.example.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.loan.wsdltojavaloanapi.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

	private static final String NAMESPACE = "http://www.example.org/spring/soap/api/loaneligibility";
	
	
	@Autowired
	private LoanEligibilityService loanEligibilityService;
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(CustomerRequest request) {
		return loanEligibilityService.checkLoanEligibility(request);
	}
	
}
