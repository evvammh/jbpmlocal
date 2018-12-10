package com.dxc.integral.workflow.servicetasks.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dxc.integral.workflow.services.clients.soap.policy.PolicyInquirySOAPClient;

public class PolicyInquiryServiceTask {

	/** The logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyInquiryServiceTask.class);

	/**
	 * Gets the Sum Insured Amount
	 * 
	 * @param policyNumber
	 *            - Policy Number
	 * @return - Sum Insured Amount
	 */
	public Double getSumInsuredAmount(Object policyNumber) {
		Double sumInsuredAmount;

		if (policyNumber instanceof String) {
			String policyNumber1 = (String) policyNumber;
			LOGGER.info("Policy Inquiry Service call started for policy number : " + policyNumber1);
			sumInsuredAmount = PolicyInquirySOAPClient.getSumInsuredAmount(policyNumber1);
			LOGGER.info("Policy Inquiry Service call ended for policy number : " + policyNumber1);
		} else {
			throw new IllegalArgumentException("Incorrect arguments supplied");
		}

		return sumInsuredAmount;
	}
}
