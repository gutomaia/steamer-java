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

	private enum Field {
		STEAM_ID("//profile/steamID"), AVATAR_ICON("//profile/avatarIcon"), AVATAR_MEDIUM("//profile/avatarMedium"), AVATAR_FULL(
				"//profile/avatarFull"), CUSTOM_URL("//profile/customURL");

		public final String xpath;

		private Field(String xpath) {
			this.xpath = xpath;
		}

	}

	String username;

	public SteamUser(String username) {
		this.username = username;
		parseProfile();
	}

	protected void parseProfile() {
		Document document = getDocument();
		steamID = getValue(Field.STEAM_ID, document);
		avatarIcon = getValue(Field.AVATAR_ICON, document);
		avatarMedium = getValue(Field.AVATAR_MEDIUM, document);
		avatarFull = getValue(Field.AVATAR_FULL, document);
		customUrl = getValue(Field.CUSTOM_URL, document);
	}

	private String getValue(Field field, Document document) {
		try {
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expression = xpath.compile(field.xpath);
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
	String avatarIcon;
	String avatarMedium;
	String avatarFull;
	String customUrl;

	public Long getSteamId64() {
		if (username.equals("gobli")) return 76561198029691735l;
		return 76561197985077150l;
	}

	public String getSteamId() {
		return steamID;
	}

	public String getAvatarIcon() {
		return avatarIcon;
	}

	public String getAvatarMedium() {
		return avatarMedium;
	}

	public String getAvatarFull() {
		return avatarFull;
	}

	public String getCustomUrl() {
		return customUrl;
	}

}
