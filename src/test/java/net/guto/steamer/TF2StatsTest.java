package net.guto.steamer;

import junit.framework.TestCase;

public class TF2StatsTest extends TestCase {

	Stats stats;

	@Override
	protected void setUp() throws Exception {
		StatsClient client = new StatsClient();
		stats = client.getStats("gutomaia", "tf2");
		assertNotNull(stats);
	}

	public void testTF2GameFriendlyName() {
		assertEquals("TF2", stats.getGameFriendlyName());
	}

	public void testTF2GameName() {
		assertEquals("Team Fortress 2", stats.getGameName());
	}

	public void testTF2GameLink() {
		assertEquals("http://store.steampowered.com/app/440", stats.getGameLink());
	}

	public void testTF2GameIcon() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/e3f595a92552da3d664ad00277fad2107345f743.jpg",
				stats.getGameIcon());
	}

	public void testTF2Logo() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg",
				stats.getLogo());
	}

	public void testTF2LogoSmall() {
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8_thumb.jpg",
				stats.getLogoSmall());
	}
}
