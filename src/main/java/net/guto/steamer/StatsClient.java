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
		GAME_ICON("/playerstats/game/gameIcon", STRING);

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
		if (game.equals("portal2")) {
			stats.gameLogo = "http://media.steampowered.com/steamcommunity/public/images/apps/620/d2a1119ddc202fab81d9b87048f495cbd6377502.jpg";
			stats.gameLogoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/620/d2a1119ddc202fab81d9b87048f495cbd6377502_thumb.jpg";
		} else if (game.equals("tf2")) {
			stats.gameLogo = "http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg";
			stats.gameLogoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8_thumb.jpg";
		} else if (game.equals("l4d2")) {
			stats.gameLogo = "http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142.jpg";
			stats.gameLogoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142_thumb.jpg";
		}
		Document document = getDocument("src/test/resources/" + username + "-" + game + ".xml");
		stats.gameFriendlyName = getStringValue(StatsField.GAME_FRIENDLY_NAME, document);
		stats.gameName = getStringValue(StatsField.GAME_NAME, document);
		stats.gameLink = getStringValue(StatsField.GAME_LINK, document);
		stats.gameIcon = getStringValue(StatsField.GAME_ICON, document);
		return stats;
	}
}
