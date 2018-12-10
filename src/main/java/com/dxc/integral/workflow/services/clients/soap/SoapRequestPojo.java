package com.dxc.integral.workflow.services.clients.soap;

/**
 * The SoapRequestPojo.
 * 
 * @author vhukumagrawa
 *
 */
public class SoapRequestPojo {

	/** The localName */
	private String localName;
	/** The prefix */
	private String prefix;
	/** The uri */
	private String uri;
	/** The textNode */
	private String textNode;

	public SoapRequestPojo(String localName, String prefix, String uri, String textNode) {
		this.localName = localName;
		this.prefix = prefix;
		this.uri = uri;
		this.textNode = textNode;
	}

	/**
	 * Getter for localName
	 * 
	 * @return - String - localName
	 */
	public String getLocalName() {
		return localName;
	}

	/**
	 * Setter for localName
	 * 
	 * @param localName
	 *            - localName
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	/**
	 * Getter for prefix
	 * 
	 * @return - String - prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Setter for prefix
	 * 
	 * @param prefix
	 *            - prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Getter for uri
	 * 
	 * @return - String - uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Setter for uri
	 * 
	 * @param uri
	 *            - the uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Getter for textNode
	 * 
	 * @return - String - textNode
	 */
	public String getTextNode() {
		return textNode;
	}

	/**
	 * Setter for textNode
	 * 
	 * @param textNode
	 *            - the textNode
	 */
	public void setTextNode(String textNode) {
		this.textNode = textNode;
	}

}
