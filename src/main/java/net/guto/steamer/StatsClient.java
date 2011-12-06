package net.guto.steamer;

public class StatsClient {

	public Stats getStats(String username, String game) {
		if (game.equals("tf2")) {
			TF2Stats tf2Stats = new TF2Stats();
			tf2Stats.gameFriendlyName = "TF2";
			tf2Stats.gameName = "Team Fortress 2";
			tf2Stats.gameLink = "http://store.steampowered.com/app/440";
			tf2Stats.gameIcon = "http://media.steampowered.com/steamcommunity/public/images/apps/440/e3f595a92552da3d664ad00277fad2107345f743.jpg";
			tf2Stats.logo = "http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg";
			tf2Stats.logoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8_thumb.jpg";
			return tf2Stats;
		}
		Stats stats = new Stats();
		stats.gameFriendlyName = "L4D2";
		stats.gameName = "Left 4 Dead 2";
		stats.gameLink = "http://store.steampowered.com/app/550";
		stats.gameIcon = "http://media.steampowered.com/steamcommunity/public/images/apps/550/7d5a243f9500d2f8467312822f8af2a2928777ed.jpg";
		stats.logo = "http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142.jpg";
		stats.logoSmall = "http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142_thumb.jpg";
		return stats;
	}
}
