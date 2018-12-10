package com.dxc.integral.workflow.services.clients.soap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.dxc.integral.exceptions.IntegralWorkflowException;

/**
 * The SOAPConnectionUtil
 * 
 * @author vhukumagrawa
 *
 */
public class SOAPConnectionUtil {
	
	/** The Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(SOAPConnectionUtil.class);
	
	/** The SOAPConnectionFactory object to store SOAPConnectionFactory */
	private SOAPConnectionFactory scf;
	
	/** The SOAPConnection object to store SOAPConnection*/
	private SOAPConnection conn;
	
	/** The Document object to store soap response */
	private Document responseDoc;

	/**
	 * SOAPConnectionUtil constructor.
	 * 
	 * @throws SOAPException
	 */
	public SOAPConnectionUtil() throws SOAPException {
		scf = SOAPConnectionFactory.newInstance();
		conn = scf.createConnection();
	}

	/**
	 * Call Service and prepare response document.
	 * 
	 * @param msg - the SOAPMessage
	 * @param url - Web Service URL
	 * @throws IntegralWorkflowException 
	 */
	public void callService(SOAPMessage msg, String url) throws IntegralWorkflowException{
		try {
		SOAPMessage rp = conn.call(msg, url);
		LOGGER.info("Calling Service");
		// Create transformer
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();

		Source sc = rp.getSOAPPart().getContent();

		LOGGER.debug("----------------------------");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		Result outputTarget = new StreamResult(outputStream);
		tf.transform(sc, outputTarget);
		LOGGER.debug(outputStream.toString());

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
		responseDoc = builder.parse(is);
		LOGGER.debug("----------------------------");
		LOGGER.info("Response Fetched");
		} catch(SOAPException | TransformerException | ParserConfigurationException | SAXException | IOException ex) {
			LOGGER.error("Exception occurred during Integral SOAP web service call : " + ex);
			throw new IntegralWorkflowException();
		}

	}

	/**
	 * Close SOAPConnection.
	 * 
	 * @throws SOAPException
	 */
	public void closeConnection() throws SOAPException {
		conn.close();
	}

	/**
	 * Gets Response document.
	 * 
	 * @return - responseDoc
	 */
	public Document getResponseDoc() {
		return responseDoc;
	}

}
