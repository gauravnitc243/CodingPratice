package com.oracle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class DocuSignSOAPClient {

	public static void main(String[] args) {
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "https://demo.docusign.net/api/3.0/api.asmx?WSDL";
			SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
			printSOAPResponse(soapResponse);
			soapConnection.close();
		} catch (Exception e) {
			System.err.println("Error occurred while sending SOAP Request to Server");
			e.printStackTrace();
		}
	}

	private static SOAPMessage createSOAPRequest() throws Exception {
		/*
		 * String soapMessageString =
		 * "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ns=\"http://www.docusign.net/API/3.0\">"
		 * + "<soap:Header>"+
		 * "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" soap:mustUnderstand=\"1\">"
		 * + "<wsse:UsernameToken wsu:Id=\"UsernameToken-1\">"+
		 * "<wsse:Username>[ORAC-12a29f73-7254-4974-8195-b9f1b8a9add1]jitender.k.kumar@oracle.com</wsse:Username>"+
		 * "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">welcome1</wsse:Password>"
		 * + "</wsse:UsernameToken>"+ "</wsse:Security>"+ "</soap:Header>"+
		 * "<soap:Body>"+ "<ns:RequestEnvelopeHistoryToken>"+ "<ns:Arg>"+
		 * "<ns:EnvelopeId>66f8cf28-32e4-4d78-9208-0bee3131b442</ns:EnvelopeId>"+
		 * "<ns:ReturnURL></ns:ReturnURL>"+ "</ns:Arg>"+
		 * "</ns:RequestEnvelopeHistoryToken>"+ " </soap:Body>"+
		 * "</soap:Envelope>";
		 */

		/*
		 * String historyURLSOAPRequest =
		 * "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ns=\"http://www.docusign.net/API/3.0\"  xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\" >"
		 * + "<soap:Header>"+
		 * "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" soap:mustUnderstand=\"1\">"
		 * + "<wsse:UsernameToken wsu:Id=\"UsernameToken-1\">"+
		 * "<wsse:Username>[ORAC-12a29f73-7254-4974-8195-b9f1b8a9add1]8e3ce426-20f3-4de4-a886-5b7407fe4f39</wsse:Username>"+
		 * "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welcome1234</wsse:Password>"
		 * + "</wsse:UsernameToken>"+ "</wsse:Security>"+ "</soap:Header>"+
		 * "<soap:Body>"+ "<ns:RequestEnvelopeHistoryToken>"+ "<ns:Arg>"+
		 * "<ns:EnvelopeId>ba55d02b-7312-4f4e-8994-dc2611eed373</ns:EnvelopeId>"+
		 * "<ns:ReturnURL></ns:ReturnURL>"+ "</ns:Arg>"+
		 * "</ns:RequestEnvelopeHistoryToken>"+ " </soap:Body>"+
		 * "</soap:Envelope>";
		 */

		String soapMessageString = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ns=\"http://www.docusign.net/API/3.0\"  xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\" >"
				+ "<soap:Header>"
				+ "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" soap:mustUnderstand=\"1\">"
				+ "<wsse:UsernameToken wsu:Id=\"UsernameToken-1\">"
				+ "<wsse:Username>[ORAC-12a29f73-7254-4974-8195-b9f1b8a9add1]jeet.choudhary7@gmail.com</wsse:Username>"
				+ "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">welcome1</wsse:Password>"
				+ "</wsse:UsernameToken>" + "</wsse:Security>" + "</soap:Header>" + "<soap:Body>"
				+ "<ns:RequestEnvelopeHistoryToken>" + "<ns:Arg>"
				+ "<ns:EnvelopeId>a31990f0-3881-4d24-b065-d4e589e74b55</ns:EnvelopeId>"
				+ "<ns:ReturnURL></ns:ReturnURL>" + "</ns:Arg>" + "</ns:RequestEnvelopeHistoryToken>" + " </soap:Body>"
				+ "</soap:Envelope>";

		String msg = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ns=\"http://www.docusign.net/API/3.0\" "
				+ " xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\" ><soap:Header><wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\""
				+ " xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" soap:mustUnderstand=\"1\"><wsse:UsernameToken wsu:Id=\"UsernameToken-1\">"
				+ "<wsse:Username>[ORAC-12a29f73-7254-4974-8195-b9f1b8a9add1][jitender.k.kumar@oracle.com]cntr.mgr@gmail.com</wsse:Username>"
				+ "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welcome1234</wsse:Password></wsse:UsernameToken></wsse:Security>"
				+ "</soap:Header><soap:Body><ns:RequestEnvelopeHistoryToken><ns:Arg><ns:EnvelopeId>3069a740-bc24-49e0-80d0-a46f2b8245bb</ns:EnvelopeId>"
				+ "<ns:ReturnURL>http://www.docusign.com/p/membernet/finish_signing_demo.php</ns:ReturnURL></ns:Arg></ns:RequestEnvelopeHistoryToken></soap:Body></soap:Envelope>";

		MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
		SOAPMessage soapMessage = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(msg.getBytes(Charset.forName("UTF-8"))));
		System.out.println(soapMessageString);
		MimeHeaders mimeHeader = soapMessage.getMimeHeaders();
		// mimeHeader.setHeader("SOAPAction",
		// "http://www.docusign.net/API/3.0/RequestEnvelopeHistoryToken");
		mimeHeader.setHeader("SOAPAction",
				"http://demo.docusign.net/API/3.0/APIServiceSoap/RequestEnvelopeHistoryTokenRequest");
		return soapMessage;
	}

	private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		StreamResult result = new StreamResult(output);
		transformer.transform(sourceContent, result);
		System.out.println("\nResponse SOAP Message = " + output.toString());
		System.out.println("return URL : " + parseXMLBody(output.toString(), "RequestEnvelopeHistoryTokenResult"));

	}

	public static void initSSL() throws Exception {
		String provider = System.getProperty("javax.net.ssl.keyStoreProvider");
		String keystoreType = System.getProperty("javax.net.ssl.keyStoreType", KeyStore.getDefaultType());
		KeyStore ks = null;
		if (provider != null) {
			ks = KeyStore.getInstance(keystoreType, provider);
		} else {
			ks = KeyStore.getInstance(keystoreType);
		}
		InputStream ksis = null;
		String keystorePath = System.getProperty("javax.net.ssl.keyStore");
		String keystorePassword = System.getProperty("javax.net.ssl.keyStorePassword");
		if (keystorePath != null && !"NONE".equals(keystorePath)) {
			ksis = new FileInputStream(keystorePath);
		}
		try {
			ks.load(ksis, keystorePassword.toCharArray());
		} finally {
			if (ksis != null) {
				ksis.close();
			}
		}

		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmf.init(ks, keystorePassword.toCharArray());
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(kmf.getKeyManagers(), null, null);
	}

	public static void initSecondSSL() throws Exception {
		SSLContext context = SSLContext.getInstance("TLS");
		String keyStore = System.getProperty("javax.net.ssl.keyStore");
		String keyStoreType = System.getProperty("javax.net.ssl.keyStoreType", KeyStore.getDefaultType());
		String keyStorePassword = System.getProperty("javax.net.ssl.keyStorePassword", "");
		KeyManager[] kms = null;
		if (keyStore != null) {
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			KeyStore ks = KeyStore.getInstance(keyStoreType);
			if (keyStore != null && !keyStore.equals("NONE")) {
				FileInputStream fs = new FileInputStream(keyStore);
				ks.load(fs, keyStorePassword.toCharArray());
				if (fs != null)
					fs.close();
				char[] password = null;
				if (keyStorePassword.length() > 0)
					password = keyStorePassword.toCharArray();
				kmf.init(ks, password);
				kms = kmf.getKeyManagers();
			}
			context.init(kms, null, null);
		}
	}

	private static String parseXMLBody(String body, String searchToken) {
		String xPathExpression;
		try {
			xPathExpression = String.format("//*[1]/*[local-name()='%s']", searchToken);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String string_searched = (xPath.evaluate(xPathExpression, new InputSource(new StringReader(body))));
			return string_searched;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
