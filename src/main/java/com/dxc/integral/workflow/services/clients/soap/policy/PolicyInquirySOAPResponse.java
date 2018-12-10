package com.dxc.integral.workflow.services.clients.soap.policy;

import com.dxc.integral.workflow.services.clients.soap.IntegralSOAPResponse;

/**
 * Policy Inquiry SOAP Response.
 * 
 * @author VHukumagrawa
 *
 */
public class PolicyInquirySOAPResponse extends IntegralSOAPResponse {

	/**
	 * Sum Insured Amount
	 */
	private Double sumInsuredAmount;

	/**
	 * Gets the Sum Insured Amount
	 * 
	 * @return - Sum Insured Amount
	 */
	public Double getSumInsuredAmount() {
		return sumInsuredAmount;
	}

	/**
	 * Sets the Sum Insured Amount
	 * 
	 * @param sumInsuredAmount
	 *            - Sum Insured Amount
	 */
	public void setSumInsuredAmount(Double sumInsuredAmount) {
		this.sumInsuredAmount = sumInsuredAmount;
	}

}
