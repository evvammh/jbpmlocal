package com.dxc.integral.workflow.services.clients.soap.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PolicyInquirySOAPClient {

	/** The logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyInquirySOAPClient.class);

	private PolicyInquirySOAPClient() {

	}

	/**
	 * Gets the Sum Insured Amount
	 * 
	 * @param policyNumber
	 *            - Policy Number
	 * @return - Sum Insured Amount
	 */
	public static Double getSumInsuredAmount(String policyNumber) {

		PolicyInquirySOAPRequest request = new PolicyInquirySOAPRequest();
		try {
			LOGGER.info("Policy Inquiry Service started for policy number :" + policyNumber);
			request.initialize();
			request.createSoapRequest(policyNumber);
			request.callService();
			request.getDataFromResponse();
			LOGGER.info("Servic Call Status: " + request.getSoapResponse().getStatus());
			LOGGER.info("Policy Inquiry Service ended for policy number :" + policyNumber);
			LOGGER.info("Policy Sum Insured Amount is: " + request.getSoapResponse().getSumInsuredAmount());
			return request.getSoapResponse().getSumInsuredAmount();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred during Policy Inquiry Service call: " + e);
		}
		return null;
	}
	
}
