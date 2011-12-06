package net.guto.steamer;

import static javax.xml.xpath.XPathConstants.STRING;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SteamUser {

	private enum Field {
		STEAM_ID64("//profile/steamID64", STRING),
		STEAM_ID("//profile/steamID", STRING),
		AVATAR_ICON("//profile/avatarIcon", STRING),
		AVATAR_MEDIUM("//profile/avatarMedium", STRING),
		AVATAR_FULL("//profile/avatarFull", STRING),
		CUSTOM_URL("//profile/customURL", STRING);

		public final String xpath;
		public final QName dataType;

		private Field(String xpath, QName dataType) {
			this.xpath = xpath;
			this.dataType = dataType;
		}
	}

	String username;

	public SteamUser(String username) {
		this.username = username;
		parseProfile();
	}

	protected void parseProfile() {
		Document document = getDocument();
		steamId64 = getLongValue(Field.STEAM_ID64, document);
		steamID = getStringValue(Field.STEAM_ID, document);
		avatarIcon = getStringValue(Field.AVATAR_ICON, document);
		avatarMedium = getStringValue(Field.AVATAR_MEDIUM, document);
		avatarFull = getStringValue(Field.AVATAR_FULL, document);
		customUrl = getStringValue(Field.CUSTOM_URL, document);
	}
	
	private Long getLongValue(Field field, Document document){
		return Long.parseLong((String) getValue(field, document));
	}

	private String getStringValue(Field field, Document document) {
		return (String) getValue(field, document);
	}

	private Object getValue(Field field, Document document) {
		try {
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expression = xpath.compile(field.xpath);
			return expression.evaluate(document, field.dataType);
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

	Long steamId64;
	String steamID;
	String avatarIcon;
	String avatarMedium;
	String avatarFull;
	String customUrl;

	public Long getSteamId64() {
		return steamId64;
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
