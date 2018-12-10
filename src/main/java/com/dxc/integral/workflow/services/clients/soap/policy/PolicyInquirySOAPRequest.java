package com.dxc.integral.workflow.services.clients.soap.policy;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.dxc.integral.exceptions.IntegralWorkflowException;
import com.dxc.integral.workflow.config.Config;
import com.dxc.integral.workflow.services.clients.soap.SOAPConnectionUtil;
import com.dxc.integral.workflow.services.clients.soap.SoapRequestCreator;
import com.dxc.integral.workflow.services.clients.soap.SoapRequestPojo;

/**
 * Policy Inquiry SOAP Request
 * 
 * @author VHukumagrawa
 *
 */
public class PolicyInquirySOAPRequest {

	/** The logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyInquirySOAPRequest.class);
	public static final String ENVELOP_PREFIX = "soap";
	public static final String IMPL_PREFIX = "impl";
	public static final String XSD_PREFIX = "xsd";
	public static final String XSD1_PREFIX = "xsd1";
	public static final String XSD2_PREFIX = "xsd2";
	public static final String XSD3_PREFIX = "xsd3";
	public static final String XSD4_PREFIX = "xsd4";
	public static final String XSD5_PREFIX = "xsd5";

	public static final String SUCCESS = "1";
	public static final String FAIL = "0";
	public static final String NO_STATUS = "2";

	private SOAPMessage message;
	private SoapRequestCreator soapCreator;
	private String serviceUrl;
	private Document responseDoc;
	private PolicyInquirySOAPResponse soapResponse;

	/**
	 * Initialization to be done before creating SOAP request.
	 * 
	 * @throws SOAPException
	 */
	public void initialize() throws SOAPException {
		serviceUrl = Config.getPolicyInquiryServiceURL();
		LOGGER.info("Service URL : " + serviceUrl);
		MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		message = messageFactory.createMessage();
		message.getSOAPPart().getEnvelope().setPrefix(ENVELOP_PREFIX);
		message.getSOAPPart().getEnvelope().removeNamespaceDeclaration("env");
		message.getSOAPHeader().setPrefix(ENVELOP_PREFIX);
		message.getSOAPBody().setPrefix(ENVELOP_PREFIX);
		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope soapEnvelop = soapPart.getEnvelope();
		soapCreator = new SoapRequestCreator(soapEnvelop);
	}

	/**
	 * Create SOAP request. This method adds namespaces and body elements.
	 * 
	 * @param policyNumber
	 *            - The Policy Number
	 * @throws SOAPException
	 *             - the SOAPException
	 */
	public void createSoapRequest(String policyNumber) throws SOAPException {
		/* Create namespaces */
		List<SoapRequestPojo> nameSpaceList = new ArrayList<>();
		nameSpaceList.add(new SoapRequestPojo(null, IMPL_PREFIX,
				"http://impl.services.pvpmpolicydetail.polisy.generatedsoapservices.ws.integral.csc.com", null));
		nameSpaceList.add(new SoapRequestPojo(null, XSD_PREFIX,
				"http://in.pvpmpolicydetail.polisy.generatedsoapservices.ws.integral.csc.com/xsd", null));
		nameSpaceList.add(new SoapRequestPojo(null, XSD1_PREFIX, "http://authenticate.integral.csc.com/xsd", null));
		nameSpaceList.add(new SoapRequestPojo(null, XSD2_PREFIX, "http://screens.bojsp.msp.csc/xsd", null));
		nameSpaceList.add(new SoapRequestPojo(null, XSD3_PREFIX, "http://utils.bojsp.msp.csc/xsd", null));
		nameSpaceList.add(new SoapRequestPojo(null, XSD4_PREFIX, "http://screens.ws.integral.csc.com/xsd", null));
		nameSpaceList.add(new SoapRequestPojo(null, XSD5_PREFIX,
				"http://out.pvpmpolicydetail.polisy.generatedsoapservices.ws.integral.csc.com/xsd", null));

		soapCreator.createNamespaces(nameSpaceList);
		SOAPElement soapRunService = soapCreator
				.addElementOnBody(new SoapRequestPojo("runService", IMPL_PREFIX, null, null), ENVELOP_PREFIX);
		SOAPElement in = soapCreator.addChildElement(soapRunService,
				new SoapRequestPojo("in", IMPL_PREFIX, null, null));
		SOAPElement authenticationInfo = soapCreator.addChildElement(in,
				new SoapRequestPojo("authenticationInfo", XSD_PREFIX, null, null));
		soapCreator.addChildElement(authenticationInfo,
				new SoapRequestPojo("username", XSD1_PREFIX, null, Config.getUserid()));
		soapCreator.addChildElement(authenticationInfo,
				new SoapRequestPojo("password", XSD1_PREFIX, null, Config.getPassword()));
		SOAPElement s0017 = soapCreator.addChildElement(in, new SoapRequestPojo("s0017", XSD_PREFIX, null, null));
		soapCreator.addChildElement(s0017, new SoapRequestPojo("screenName", XSD2_PREFIX, null, "S0017"));
		
		SOAPElement s4372 = soapCreator.addChildElement(in, new SoapRequestPojo("s4372", XSD_PREFIX, null, null));
		soapCreator.addChildElement(s4372, new SoapRequestPojo("action", XSD4_PREFIX, null, "A"));
		soapCreator.addChildElement(s4372, new SoapRequestPojo("inqkey", XSD4_PREFIX, null, policyNumber));
		
		SOAPElement s4817 = soapCreator.addChildElement(in, new SoapRequestPojo("s4817", XSD_PREFIX, null, null));
		soapCreator.addChildElement(s4817, new SoapRequestPojo("actionKey", XSD4_PREFIX, null, "PFKEY0"));
		SOAPElement s4817screensfl = soapCreator.addChildElement(s4817, new SoapRequestPojo("s4817screensfl", XSD4_PREFIX, null, null));
		SOAPElement attributeList1 = soapCreator.addChildElement(s4817screensfl, new SoapRequestPojo("attributeList", XSD4_PREFIX, null, null));
		soapCreator.addChildElement(attributeList1, new SoapRequestPojo("key", XSD3_PREFIX, null, "s4817screensfl.action_R1"));
		soapCreator.addChildElement(attributeList1, new SoapRequestPojo("value", XSD3_PREFIX, null, "1"));
		
		SOAPElement sm403 = soapCreator.addChildElement(in, new SoapRequestPojo("sm403", XSD_PREFIX, null, null));
		soapCreator.addChildElement(sm403, new SoapRequestPojo("actionKey", XSD4_PREFIX, null, "PFKEY03"));
		
		soapCreator.addChildElement(soapRunService, new SoapRequestPojo("out", IMPL_PREFIX, null, null));
		message.saveChanges();

	}

	/**
	 * Calls SOAP Service and fetch response.
	 * 
	 * @throws IntegralWorkflowException
	 */
	public void callService() throws IntegralWorkflowException {
		try {
			SOAPConnectionUtil connectionUtil = new SOAPConnectionUtil();
			connectionUtil.callService(message, serviceUrl);
			responseDoc = connectionUtil.getResponseDoc();
			connectionUtil.closeConnection();
		} catch (IntegralWorkflowException | SOAPException ex) {
			LOGGER.error("Exception occurred during Integral SOAP Service Call : " + ex);
			throw new IntegralWorkflowException();
		}
	}

	/**
	 * Parse response doc and prepares UWApprovalSOAPResponse POJO.
	 */
	public void getDataFromResponse() {
		soapResponse = new PolicyInquirySOAPResponse();
		if (responseDoc != null) {
			NodeList nodeList = responseDoc.getElementsByTagName("ns:return");
			if (nodeList.item(0) != null && nodeList.item(0).hasChildNodes()) {
				parseServiceResponse(nodeList);
			}
			NodeList faultListOut = responseDoc.getElementsByTagName("soapenv:Fault");
			if (faultListOut.item(0) != null && faultListOut.item(0).hasChildNodes()) {
				String id = responseDoc.getElementsByTagName("faultcode").item(0).getTextContent().trim();
				String msg = responseDoc.getElementsByTagName("faultstring").item(0).getTextContent().trim();
				soapResponse.setErrorId(id);
				soapResponse.setErrorMsg(msg);
				soapResponse.setStatus(NO_STATUS);
				LOGGER.info("Service Returned Faut Message : " + msg);
			}
		}

	}

	/**
	 * Parse Web Service Response to fetch info and error messages.
	 * 
	 * @param nodeList
	 *            - NodeList
	 */
	private void parseServiceResponse(NodeList nodeList) {
		NodeList returnNodes = nodeList.item(0).getChildNodes();
		for (int i = 0; i < returnNodes.getLength(); i++) {
			if (returnNodes.item(i).getNodeName().contains("errorMessages")) {
				parseErrorMessages(returnNodes, i);
			}

			if (returnNodes.item(i).getNodeName().contains("infoMessages")) {
				parseInfoMessages(returnNodes, i);
			}
			
			if (returnNodes.item(i).getNodeName().contains("output")) {
				parseOutput(returnNodes, i);
			}
		}
	}

	/**
	 * Parse Error Messages from Web Service Response.
	 * 
	 * @param returnNodes
	 *            - NodeList
	 * @param i
	 *            - index
	 */
	private void parseErrorMessages(NodeList returnNodes, int i) {
		NodeList errorMessagesList = returnNodes.item(i).getChildNodes();
		if (errorMessagesList.getLength() > 0) {
			for (int j = 0; j < errorMessagesList.getLength(); j++) {
				if (errorMessagesList.item(j).getNodeName().contains("id")) {
					soapResponse.setErrorId(errorMessagesList.item(j).getTextContent().trim());
				}
				if (errorMessagesList.item(j).getNodeName().contains("message")) {
					soapResponse.setErrorMsg(errorMessagesList.item(j).getTextContent().trim());
				}
			}
			soapResponse.setStatus(FAIL);
			LOGGER.info("Service returned error messages");
			LOGGER.info("Error Code:" + soapResponse.getErrorId());
			LOGGER.info("Error Message:" + soapResponse.getErrorMsg());
		}
	}

	/**
	 * Parse Info Messages from Web Service Response.
	 * 
	 * @param returnNodes
	 *            - NodeList
	 * @param i
	 *            - index
	 */
	private void parseInfoMessages(NodeList returnNodes, int i) {
		NodeList infoMessagesList = returnNodes.item(i).getChildNodes();
		if (infoMessagesList.getLength() > 0) {
			for (int j = 0; j < infoMessagesList.getLength(); j++) {
				if (infoMessagesList.item(j).getNodeName().contains("message")) {
					soapResponse.setStatus(SUCCESS);
					soapResponse.setSuccessMessage(infoMessagesList.item(j).getTextContent().trim());
					break;
				}
			}
			LOGGER.info("Service call is successful.");
			LOGGER.info("Service Status : [" + soapResponse.getStatus() + "]");
			LOGGER.info("Service Success Message : [" + soapResponse.getSuccessMessage() + "]");
		}
	}
	
	/**
	 * Parse Output Value.
	 * 
	 * @param returnNodes
	 *            - NodeList
	 * @param i
	 *            - index
	 */
	private void parseOutput(NodeList returnNodes, int i) {
		NodeList outputList = returnNodes.item(i).getChildNodes();
		if (outputList.getLength() > 0) {
			for (int j = 0; j < outputList.getLength(); j++) {
				if (outputList.item(j).getNodeName().contains("sm403")) {
					getSumInsuredAmount(outputList, j);
					break;
				}
			}
		}
	}
	
	private void getSumInsuredAmount(NodeList outputList, int j) {
		NodeList sm403outputList = outputList.item(j).getChildNodes();
		for (int k = 0; k < sm403outputList.getLength(); k++) {
			if (sm403outputList.item(k).getNodeName().contains("stotsi")) {
				String sumInsuredAmount = sm403outputList.item(k).getTextContent().trim();
				soapResponse.setSumInsuredAmount(new Double(sumInsuredAmount));
				break;
			}

		}
	}

	/**
	 * Getter for PolicyInquirySOAPResponse
	 * 
	 * @return - the IntegralSOAPResponse
	 */
	public PolicyInquirySOAPResponse getSoapResponse() {
		return soapResponse;
	}

	/**
	 * Setter for PolicyInquirySOAPResponse
	 * 
	 * @param soapResponse
	 *            - IntegralSOAPResponse
	 */
	public void setSoapResponse(PolicyInquirySOAPResponse soapResponse) {
		this.soapResponse = soapResponse;
	}

}
