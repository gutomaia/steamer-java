package net.guto.steamer;

import static javax.xml.xpath.XPathConstants.NODESET;
import static javax.xml.xpath.XPathConstants.STRING;
import static net.guto.steamer.Steamer.getDocument;
import static net.guto.steamer.Steamer.getNodeListValue;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SteamGames {
	private enum GamesField implements Field {
		STEAM_ID64("/profile/steamID64", STRING), STEAM_ID("/profile/steamID", STRING), GAMES(
				"/gamesList/games/game | /gamesList/games/game/*" + "",
				NODESET);

		private XPathExpression xpath;
		private final String xpathString;
		private final QName dataType;

		private GamesField(String xpathString, QName dataType) {
			this.xpathString = xpathString;
			this.dataType = dataType;
			XPathFactory xpathFactory = XPathFactory.newInstance();
			try {
				xpath = xpathFactory.newXPath().compile(xpathString);
			} catch (XPathExpressionException e) {
				e.printStackTrace();
			}

		}

		public String getXPathString() {
			return xpathString;
		}

		public QName getDataType() {
			return dataType;
		}

		@Override
		public XPathExpression getXPath() {
			return xpath;
		}
	}

	String username;

	public SteamGames(String username) {
		this.username = username;
		parseGames();
	}

	private void parseGames() {
		Document document = getDocument("src/test/resources/gutomaia-games.xml");
		NodeList gameNodes = getNodeListValue(GamesField.GAMES, document);
		SteamGame game = null;
		games = new ArrayList<SteamGame>();
		for (int i = 0; i < gameNodes.getLength(); i++) {
			Node node = gameNodes.item(i);
			String nodeName = node.getNodeName();
			if ("game".equals(nodeName)) {
				game = new SteamGame();
				games.add(game);
			} else if ("appID".equals(nodeName)) {
				game.appID = Integer.parseInt(node.getTextContent());
			} else if ("name".equals(nodeName)) {
				game.name = node.getTextContent();
			} else if ("logo".equals(nodeName)) {
				game.logo = node.getTextContent();
			} else if ("storeLink".equals(nodeName)) {
				game.storeLink = node.getTextContent();
			} else if ("hoursLast2Weeks".equals(nodeName)) {
				game.hoursLast2Weeks = Float.parseFloat(node.getTextContent());
			} else if ("hoursOnRecord".equals(nodeName)) {
				game.hoursOnRecord = Float.parseFloat(node.getTextContent());
			} else if ("statsLink".equals(nodeName)) {
				game.statsLink = node.getTextContent();
			} else if ("globalStatsLink".equals(nodeName)) {
				game.globalStatsLink = node.getTextContent();
			}
		}
	}

	List<SteamGame> games;

	public List<SteamGame> getGames() {
		if (games == null) parseGames();
		return games;
	}
}
