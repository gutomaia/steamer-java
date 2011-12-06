package net.guto.steamer;

import static javax.xml.xpath.XPathConstants.STRING;
import static net.guto.steamer.Steamer.getDocument;
import static net.guto.steamer.Steamer.getStringValue;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;

public class StatsClient {

	private static enum StatsField implements Field {
		GAME_FRIENDLY_NAME("/playerstats/game/gameFriendlyName", STRING),
		GAME_NAME("/playerstats/game/gameName", STRING),
		GAME_LINK("/playerstats/game/gameLink", STRING),
		GAME_ICON("/playerstats/game/gameIcon", STRING),
		GAME_LOGO("/playerstats/game/gameLogo", STRING),
		GAME_LOGO_SMALL("/playerstats/game/gameLogoSmall", STRING);

		private final String xpath;
		private final QName dataType;

		private StatsField(String xpath, QName dataType) {
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

	public Stats getStats(String username, String game) {
		Stats stats = new Stats();
		Document document = getDocument("src/test/resources/" + username + "-" + game + ".xml");
		stats.gameFriendlyName = getStringValue(StatsField.GAME_FRIENDLY_NAME, document);
		stats.gameName = getStringValue(StatsField.GAME_NAME, document);
		stats.gameLink = getStringValue(StatsField.GAME_LINK, document);
		stats.gameIcon = getStringValue(StatsField.GAME_ICON, document);
		stats.gameLogo = getStringValue(StatsField.GAME_LOGO, document);
		stats.gameLogoSmall = getStringValue(StatsField.GAME_LOGO_SMALL, document);
		return stats;
	}
}
