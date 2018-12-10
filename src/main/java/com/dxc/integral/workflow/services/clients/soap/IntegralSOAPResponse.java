package com.dxc.integral.workflow.services.clients.soap;

/**
 * Integral SOAO Response bean.
 * 
 * @author vhukumagrawa
 *
 */
public class IntegralSOAPResponse {

	/** The errorId */
	private String errorId;
	/** The errorMsg */
	private String errorMsg;
	/** The status */
	private String status;
	/** The successMessage */
	private String successMessage;

	/**
	 * Getter for errorId
	 * 
	 * @return - errorId
	 */
	public String getErrorId() {
		return errorId;
	}

	/**
	 * Setter for errorId
	 * 
	 * @param errorId-
	 *            errorId
	 */
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	/**
	 * Getter for errorMsg
	 * 
	 * @return - errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Setter for errorMsg
	 * 
	 * @param errorMsg
	 *            - errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Getter for status
	 * 
	 * @return - status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Setter for status
	 * 
	 * @param status
	 *            - status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Getter for successMessage
	 * 
	 * @return - successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * Setter for successMessage
	 * 
	 * @param successMessage
	 *            - successMessage
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}



}
