package net.guto.steamer;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Steamer {

	public SteamUser getUser(String steamId) {
		SteamUser user = new SteamUser(steamId);
		return user;
	}

	public List<SteamGame> getGames(String steamId) {
		SteamGames steamGames = new SteamGames(steamId);
		return steamGames.getGames();
	}

	protected static Long getLongValue(final Field field, final Document document) {
		return Long.parseLong((String) getValue(field, document));
	}

	protected static String getStringValue(final Field field, final Document document) {
		return (String) getValue(field, document);
	}

	protected static NodeList getNodeListValue(final Field field, final Document document) {
		return (NodeList) getValue(field, document);
	}

	static XPathFactory xpathFactory = XPathFactory.newInstance();

	protected static Object getValue(final Field field, final Document document) {
		try {
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expression = xpath.compile(field.getXPath());
			return expression.evaluate(document, field.getDataType());
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			return null;
		}
	}

	static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	protected static Document getDocument(final String xml) {
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(xml);
			return document;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
