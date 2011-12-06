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

	String username;

	public SteamUser(String username) {
		this.username = username;
		parseProfile();
	}

	protected void parseProfile() {
		Document document = getDocument();
		steamID = getValue("//profile/steamID", document);
	}

	private String getValue(String xpathStr, Document document) {
		try {
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expression = xpath.compile(xpathStr);
			return (String) expression.evaluate(document, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Document getDocument() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("src/test/resources/" + username + ".xml");
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

	String steamID;

	public Long getSteamId64() {
		if (username.equals("gobli")) return 76561198029691735l;
		return 76561197985077150l;
	}

	public String getSteamId() {
		return steamID;
	}

	public String getAvatarIcon() {
		if (username.equals("gobli")) return "http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b.jpg";
		return "http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706.jpg";
	}

	public String getAvatarMedium() {
		if (username.equals("gobli")) return "http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b_medium.jpg";
		return "http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_medium.jpg";
	}

	public String getAvatarFull() {
		if (username.equals("gobli")) return "http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_full.jpg";
		return "http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_full.jpg";
	}
}
