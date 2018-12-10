package com.dxc.integral.workflow.services.clients.soap;

import java.util.List;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;

/**
 * The SoapRequestCreator. It implements common methods to for SOAP request
 * creation.
 * 
 * @author vhukumagrawa
 *
 */
public class SoapRequestCreator {

	/**
	 * The SOAPEnvelope object.
	 */
	private SOAPEnvelope soapEnvelop;

	public SoapRequestCreator(SOAPEnvelope soapEnvelop) {
		this.soapEnvelop = soapEnvelop;
	}

	/**
	 * Creates Namespaces for Web Service Request.
	 * 
	 * @param envelopNamespaces
	 *            - List of Name spaces to create.
	 * @throws SOAPException
	 *             - the SOAPException
	 */
	public void createNamespaces(List<SoapRequestPojo> envelopNamespaces) throws SOAPException {
		for (SoapRequestPojo soapPojo : envelopNamespaces) {
			this.soapEnvelop.addNamespaceDeclaration(soapPojo.getPrefix(), soapPojo.getUri());
		}
	}

	/**
	 * Adds elements to SOAP body.
	 * 
	 * @param soapPojo
	 *            - The SoapRequestPojo
	 * @param prefix
	 *            - Prefix
	 * @return - the SOAPElement
	 * @throws SOAPException
	 *             - the SOAPException
	 */
	public SOAPElement addElementOnBody(SoapRequestPojo soapPojo, String prefix) throws SOAPException {
		SOAPElement soapElement;
		SOAPBody soapBody = this.soapEnvelop.getBody();
		if (prefix != null) {
			soapBody.setPrefix(prefix);
		}
		soapElement = soapBody.addChildElement(soapBody.createQName(soapPojo.getLocalName(), soapPojo.getPrefix()));
		return soapElement;
	}

	/**
	 * Add child elements to SOAP body.
	 * 
	 * @param parentElement
	 *            - the SOAPElement
	 * @param soapPojo
	 *            - the SoapRequestPojo
	 * @return - the SOAPElement
	 * @throws SOAPException
	 *             - the SOAPException
	 */
	public SOAPElement addChildElement(SOAPElement parentElement, SoapRequestPojo soapPojo) throws SOAPException {
		SOAPElement soapElement;
		if (soapPojo.getPrefix() != null) {
			soapElement = parentElement
					.addChildElement(parentElement.createQName(soapPojo.getLocalName(), soapPojo.getPrefix()));
		} else {
			soapElement = parentElement.addChildElement(soapPojo.getLocalName());
		}
		if (soapPojo.getTextNode() != null) {
			soapElement.addTextNode(soapPojo.getTextNode());
		}
		return soapElement;
	}

}
