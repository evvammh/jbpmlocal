package com.dxc.integral.workflow.servicetasks.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dxc.integral.workflow.services.clients.soap.policy.PolicyIssuanceSOAPClient;

public class PolicyIssuanceServiceTask {

	/** The logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyIssuanceServiceTask.class);

	/**
	 * Issues Policy
	 * 
	 * @param policyNumber
	 *            - Policy Number
	 */
	public void issuePolicy(Object policyNumber) {
		if (policyNumber instanceof String) {
			String policyNumber1 = (String) policyNumber;
			LOGGER.info("Policy Issuance Service call started for policy number : " + policyNumber1);
			PolicyIssuanceSOAPClient.issuePolicy(policyNumber1);
			LOGGER.info("Policy Issuance Service call ended for policy number : " + policyNumber1);
		} else {
			throw new IllegalArgumentException("Incorrect arguments supplied");
		}

	}
}
