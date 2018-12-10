package com.dxc.integral.workflow.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration for workflow.
 * 
 * @author VHukumagrawa
 *
 */
public class Config {
	
	/** The logger for Config */
	private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

	/** The properties */
	private static Properties props;
	
	private Config(){
		
	}

	static {
		props = new Properties();
		try {
			props.load(new FileReader(System.getProperty("polisyworkflowconfig")));
		} catch (IOException e) {
			LOGGER.error("Exception occurred while loading web service configurations: " + e);
		}
	}

	/**
	 * Getter for Claim Approval Service URL
	 * 
	 * @return - Claim Approval Service URL
	 */
	public static String getClaimApprovalServiceURL() {
		return props.getProperty("soap.service.claimapproval");
	}
	
	/**
	 * Getter for Claim Transaction Inquiry Service URL
	 * 
	 * @return - Claim Transaction Inquiry Service URL
	 */
	public static String getClaimTransactionInquiryServiceURL() {
		return props.getProperty("soap.service.claimtransactioninquiry");
	}
	
	/**
	 * Getter for User ID for web service
	 * 
	 * @return - User ID
	 */
	public static String getUserid() {
		return props.getProperty("soap.service.userid");
	}

	/**
	 * Getter for Password for web service
	 * 
	 * @return - Password
	 */
	public static String getPassword() {
		return props.getProperty("soap.service.password");
	}

	/**
	 * Getter for Policy Inquiry Service URL
	 * 
	 * @return - Policy Inquiry Service URL
	 */
	public static String getPolicyInquiryServiceURL() {
		return props.getProperty("soap.service.policyinquiry");
	}
	
	
	/**
	 * Getter for Policy Issuance Service URL
	 * 
	 * @return - Policy Issuance Service URL
	 */
	public static String getPolicyIssuanceServiceURL() {
		return props.getProperty("soap.service.policyissuance");
	}
}
