package net.guto.steamer;

import junit.framework.TestCase;

public class StatsTest extends TestCase {

	public void testStats() {
		StatsClient client = new StatsClient();
		Stats stats = client.getStats("gutomaia", "tf2");
		assertNotNull(stats);
		TF2Stats tfstats = (TF2Stats) stats;
	}
}
