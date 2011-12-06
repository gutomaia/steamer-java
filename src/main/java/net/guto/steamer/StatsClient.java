package net.guto.steamer;

public class StatsClient {

	public Stats getStats(String username, String game) {
		return new TF2Stats();
	}
}
