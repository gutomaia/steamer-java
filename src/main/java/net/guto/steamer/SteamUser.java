package net.guto.steamer;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SteamUser {

	public SteamUser() {

	}

	protected void parseProfile() {
		try {
			Document document = getDocument();
			steamID = getValue(document);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	private String getValue(Document document) throws XPathExpressionException {
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expression = xpath.compile("//profile/steamID");
		return (String) expression.evaluate(document, XPathConstants.STRING);
	}

	private Document getDocument() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/test/resources/gutomaia.xml");
		return document;
	}

	{
		parseProfile();
	}

	String steamID;

	public Long getSteamId64() {

		return 76561197985077150l;
	}

	public String getSteamId() {
		return steamID;
	}

}
