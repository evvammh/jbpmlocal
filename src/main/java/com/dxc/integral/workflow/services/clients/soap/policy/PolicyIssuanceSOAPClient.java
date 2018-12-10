package com.dxc.integral.workflow.services.clients.soap.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PolicyIssuanceSOAPClient {

	/** The logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyIssuanceSOAPClient.class);
	
	private PolicyIssuanceSOAPClient() {
		
	}
	
	/**
	 * Issue Policy 
	 * 
	 * @param policyNumber - Policy Number
	 */
	public static void issuePolicy(String policyNumber) {
		PolicyIssuanceSOAPRequest request = new PolicyIssuanceSOAPRequest();
		try {
			LOGGER.info("Policy Issuance started for policy number :" + policyNumber);
			request.initialize();
			request.createSoapRequest(policyNumber);
			request.callService();
			request.getDataFromResponse();
			LOGGER.info("Servic Call Status: " + request.getSoapResponse().getStatus());
			LOGGER.info("Policy Issuance ended for policy number :" + policyNumber);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred during Policy Issuance Service call: " + e);
		}
	}
	
}
