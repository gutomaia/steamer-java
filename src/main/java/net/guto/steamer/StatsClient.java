package net.guto.steamer;

import static javax.xml.xpath.XPathConstants.STRING;
import static javax.xml.xpath.XPathConstants.NODESET;
import static net.guto.steamer.Steamer.getDocument;
import static net.guto.steamer.Steamer.getStringValue;
import static net.guto.steamer.Steamer.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StatsClient {

	private static enum StatsField implements Field {
		GAME_FRIENDLY_NAME("/playerstats/game/gameFriendlyName", STRING), GAME_NAME("/playerstats/game/gameName", STRING), GAME_LINK(
				"/playerstats/game/gameLink",
				STRING), GAME_ICON("/playerstats/game/gameIcon", STRING), GAME_LOGO("/playerstats/game/gameLogo", STRING), GAME_LOGO_SMALL(
				"/playerstats/game/gameLogoSmall",
				STRING), ACHIEVEMENTS("/playerstats/achievements/achievement | /playerstats/achievements/achievement/*", NODESET)

		;

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

	List<Achievement> achievements;

	public List<Achievement> getAchievements(String username, String game) {
		if (achievements == null) {
			achievements = new ArrayList<Achievement>();
			Document document = getDocument("src/test/resources/" + username + "-" + game + ".xml");
			NodeList nodes = getNodeListValue(StatsField.ACHIEVEMENTS, document);
			Achievement achievement = null;
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				String nodeName = node.getNodeName();
				if ("achievement".equals(nodeName)) {
					achievement = new Achievement();
					achievements.add(achievement);
				} else if ("iconClosed".equals(nodeName)) {
					achievement.iconClosed = node.getTextContent();
				} else if ("iconOpen".equals(nodeName)) {
					achievement.iconOpen = node.getTextContent();
				} else if ("name".equals(nodeName)) {
					achievement.name = node.getTextContent();
				} else if ("apiname".equals(nodeName)) {
					achievement.apiname = node.getTextContent();
				} else if ("description".equals(nodeName)) {
					achievement.description = node.getTextContent();
				}
			}
		}
		return achievements;
	}
}
