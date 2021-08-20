package com.loan.wsdltojavaloanapi.service;

import java.util.List;

import org.example.spring.soap.api.loaneligibility.Acknowledgement;
import org.example.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityService {

	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		
		Acknowledgement acknowledgement = new Acknowledgement();
		
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
		
		if(!(request.getAge()>30 && request.getAge()<=60)) {
			mismatchCriteriaList.add("Persion age should in between 30 to 60");
		}
		if(!(request.getYearlyIncome() >200000)) {
			mismatchCriteriaList.add("minimum income should be more than 200000");
		}
		if(!(request.getCibilScore()>500)) {
			mismatchCriteriaList.add("Low cibil score please try after 6 month");
		}
		
		if(mismatchCriteriaList.size()>0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		}else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		return acknowledgement;
	}
}
