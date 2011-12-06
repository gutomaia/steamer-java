package net.guto.steamer;

import static javax.xml.xpath.XPathConstants.STRING;
import static net.guto.steamer.Steamer.getDocument;
import static net.guto.steamer.Steamer.getLongValue;
import static net.guto.steamer.Steamer.getStringValue;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;

public class SteamUser {

	private enum UserField implements Field {
		STEAM_ID64("//profile/steamID64", STRING),
		STEAM_ID("//profile/steamID", STRING),
		AVATAR_ICON("//profile/avatarIcon", STRING),
		AVATAR_MEDIUM("//profile/avatarMedium", STRING),
		AVATAR_FULL("//profile/avatarFull", STRING),
		CUSTOM_URL("//profile/customURL", STRING),
		LOCATION("//profile/location", STRING);

		private final String xpath;
		private final QName dataType;

		private UserField(String xpath, QName dataType) {
			this.xpath = xpath;
			this.dataType = dataType;
		}

		public String getXPath() {
			return xpath;
		}

		public QName getDataType() {
			return dataType;
		}
	}

	String username;

	public SteamUser(String username) {
		this.username = username;
		parseProfile();
	}

	protected void parseProfile() {
		Document document = getDocument("src/test/resources/" + username + ".xml");
		steamId64 = getLongValue(UserField.STEAM_ID64, document);
		steamID = getStringValue(UserField.STEAM_ID, document);
		avatarIcon = getStringValue(UserField.AVATAR_ICON, document);
		avatarMedium = getStringValue(UserField.AVATAR_MEDIUM, document);
		avatarFull = getStringValue(UserField.AVATAR_FULL, document);
		customUrl = getStringValue(UserField.CUSTOM_URL, document);
		location = getStringValue(UserField.LOCATION, document);
	}

	Long steamId64;
	String steamID;
	String avatarIcon;
	String avatarMedium;
	String avatarFull;
	String customUrl;
	String location;

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

	public String getLocation() {
		return location;
	}

	List<SteamGame> games;

	public List<SteamGame> getGames() {
		if (games == null) games = new ArrayList<SteamGame>();
		return games;
	}
}