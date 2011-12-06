package net.guto.steamer;

import junit.framework.TestCase;

public class StatsTest extends TestCase {

	public void testStats() {
		StatsClient client = new StatsClient();
		Stats stats = client.getStats("gutomaia", "tf2");
		assertNotNull(stats);

		assertEquals("TF2", stats.getGameFriendlyName());
		assertEquals("Team Fortress 2", stats.getGameName());
		assertEquals("http://store.steampowered.com/app/440", stats.getGameLink());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/e3f595a92552da3d664ad00277fad2107345f743.jpg",
				stats.getGameIcon());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg",
				stats.getLogo());
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8_thumb.jpg",
				stats.getLogoSmall());

		TF2Stats tfstats = (TF2Stats) stats;
	}
}
