package net.guto.steamer;

import junit.framework.TestCase;

public class Portal2StatsTest extends TestCase {

	Stats stats;

	@Override
	protected void setUp() throws Exception {
		StatsClient client = new StatsClient();
		stats = client.getStats("gutomaia", "portal2");
		assertNotNull(stats);
	}

	public void testPortal2GameFriendlyName() {
		assertEquals("Portal2", stats.getGameFriendlyName());
	}

	public void testPortal2GameName() {
		assertEquals("Portal 2", stats.getGameName());
	}

	public void testPortal2GameLink() {
		assertEquals("http://store.steampowered.com/app/620", stats.getGameLink());
	}

	public void testPortal2GameIcon() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/620/2e478fc6874d06ae5baf0d147f6f21203291aa02.jpg",
				stats.getGameIcon());

	}

	public void testPortal2Logo() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/620/d2a1119ddc202fab81d9b87048f495cbd6377502.jpg",
				stats.getLogo());
	}

	public void testPortal2LogoSmall() {
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/apps/620/d2a1119ddc202fab81d9b87048f495cbd6377502_thumb.jpg",
				stats.getLogoSmall());
	}
}
