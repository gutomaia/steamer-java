package net.guto.steamer;

import static javax.xml.xpath.XPathConstants.STRING;
import static net.guto.steamer.Steamer.getDocument;
import static net.guto.steamer.Steamer.getStringValue;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;

public class StatsClient {

	private static enum StatsField implements Field {
		GAME_FRIENDLY_NAME("/playerstats/game/gameFriendlyName", STRING);

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
			stats.gameFriendlyName = "Portal2";
			stats.gameName = "Portal 2";
			stats.gameLink = "http://store.steampowered.com/app/620";
			stats.gameIcon = "http://media.steampowered.com/steamcommunity/public/images/apps/620/2e478fc6874d06ae5baf0d147f6f21203291aa02.jpg";
			stats.logo = "http://media.steampowered.com/steamcommunity/public/images/apps/620/d2a1119ddc202fab81d9b87048f495cbd6377502.jpg";
			stats.logoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/620/d2a1119ddc202fab81d9b87048f495cbd6377502_thumb.jpg";
			return stats;
		} else if (game.equals("tf2")) {
			stats.gameFriendlyName = "TF2";
			stats.gameName = "Team Fortress 2";
			stats.gameLink = "http://store.steampowered.com/app/440";
			stats.gameIcon = "http://media.steampowered.com/steamcommunity/public/images/apps/440/e3f595a92552da3d664ad00277fad2107345f743.jpg";
			stats.logo = "http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg";
			stats.logoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8_thumb.jpg";
		} else if (game.equals("l4d2")) {
			stats.gameFriendlyName = "L4D2";
			stats.gameName = "Left 4 Dead 2";
			stats.gameLink = "http://store.steampowered.com/app/550";
			stats.gameIcon = "http://media.steampowered.com/steamcommunity/public/images/apps/550/7d5a243f9500d2f8467312822f8af2a2928777ed.jpg";
			stats.logo = "http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142.jpg";
			stats.logoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142_thumb.jpg";
		}
		Document document = getDocument("src/test/resources/" + username + "-" + game + ".xml");
		stats.gameFriendlyName = getStringValue(StatsField.GAME_FRIENDLY_NAME, document);
		return stats;

	}
}
