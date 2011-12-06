package net.guto.steamer;

public class StatsClient {

	public Stats getStats(String username, String game) {
		if (game.equals("tf2")){
			TF2Stats tf2Stats = new TF2Stats();
			tf2Stats.gameFriendlyName = "TF2";
			tf2Stats.gameName = "Team Fortress 2";
			return tf2Stats;	
		}
		Stats stats = new Stats();
		stats.gameFriendlyName = "L4D2";
		stats.gameName = "Left 4 Dead 2";
		return stats;
		
	}
}
